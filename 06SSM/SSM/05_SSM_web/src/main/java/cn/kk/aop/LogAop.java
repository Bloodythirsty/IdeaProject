package cn.kk.aop;

import cn.kk.domain.SysLog;
import cn.kk.service.ISysLogService;
import cn.kk.utils.UUIDutils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.TimeZone;

@Component
@Aspect
public class LogAop {


    private Date visitTime; //访问的开始时间
    private Class clazz;    //访问的类
    private Method method;  //访问的方法


    @Autowired
    private HttpServletRequest request;

    @Autowired
    private ISysLogService logService;
    /*
            配置pointCut
     */
    @Pointcut("execution(* cn.kk.controller.*.*(..))")
    public void pt1(){}

    /*
            前置通知
                获取开始时间
                执行的类
                访问的方法
     */
    @Before("pt1()")
    public void doBefore(JoinPoint jp) throws NoSuchMethodException {
        //设置时间区域
        TimeZone tz = TimeZone.getTimeZone("ETC/GMT-8");
        TimeZone.setDefault(tz);
        visitTime = new Date();                             //访问的开始时间
        clazz = jp.getTarget().getClass();                  //访问的类
        String methodName = jp.getSignature().getName();    //获取方法名
        Object[] args = jp.getArgs();           //获取参数

        //获取method
        if (args == null || args.length == 0){
            method = clazz.getMethod(methodName);
        }else {
            Class[] classArgs = new Class[args.length];
            for (int i = 0; i < args.length; i++) {
                classArgs[i] = args[i].getClass();
            }
            method = clazz.getMethod(methodName,classArgs);
        }

    }

    /*
            后置通知
     */
    @After("pt1()")
    public void doAfter() throws Exception {
        long time = new Date().getTime() - visitTime.getTime(); //访问时常

        //获取url
        String url = null;
        if (clazz != null && method != null && clazz != LogAop.class){
            //获取类上的注解
            RequestMapping requestMapping = (RequestMapping) clazz.getAnnotation(RequestMapping.class);
            if (requestMapping != null){
                //取出值
                String[] value = requestMapping.path();
                String firstURL = value[0];

                //取方法上的注解
                RequestMapping requestMapping1 = method.getAnnotation(RequestMapping.class);
                if (requestMapping1 != null) {
                    //取值
                    String[] value1 = requestMapping1.path();
                    String secondURL = value1[0];

                    url = firstURL+secondURL;
                }
            }
        }

        /*
                获取ip地址：通过request
                1. 怎么获得request对象？
                    1. web.xml里面配置listener：RequestContextListener
                    2. 直接注入一个request即可
         */
        String ip = request.getRemoteAddr();

        /*
                获取用户名
         */
        SecurityContext context = SecurityContextHolder.getContext();
        User user = (User) context.getAuthentication().getPrincipal();
        String username = user.getUsername();

        /*
                封装
         */
        SysLog sysLog = new SysLog();
        sysLog.setId(UUIDutils.getLowerUUID());
        sysLog.setExecutionTime(time);
        sysLog.setIp(ip);
        // sysLog.setMethod("[类名] "+clazz.getName()+" [方法名] "+method.getName());
        sysLog.setMethod(clazz.getName()+"."+method.getName());
        sysLog.setUrl(url);
        sysLog.setUsername(username);
        sysLog.setVisitTime(visitTime);

        logService.saveLog(sysLog);

    }


}
