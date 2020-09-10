package cn.itcast.travel.web.servlet;

import cn.itcast.travel.domain.ResultInfo;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.UserService;
import cn.itcast.travel.service.impl.UserServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;


/*
        1. 每次访问，都会先访问BaseServlet的service方法
        2. 若继承HttpServlet，也会先访问service，用于查看哪种请求x方式
 */
@WebServlet("/user/*")
public class UserServlet extends BaseServlet {
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//    }
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        this.doPost(request, response);
//    }

    private UserService userService = new UserServiceImpl();

//    protected void toJson(HttpServletResponse response, ResultInfo resultInfo) throws IOException {
//        //5. 将resultInfo 序列化为json
//        ObjectMapper mapper = new ObjectMapper();
//        response.setContentType("application/json;charset=utf-8");
//        mapper.writeValue(response.getWriter(), resultInfo);
//    }
    //将toJson直接抽取到BaseServlet里面，直接调用

    protected void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       // System.out.println("userServlet 的  add");
        //1. 验证码,先从客户端获取
        String check = request.getParameter("check");
        //2. 从Session获取验证码，用于比较从客户端获取到的
        String checkcode_server = (String) request.getSession().getAttribute("CHECKCODE_SERVER");
        //2.1 Session，不然后退有验证码不变
        request.getSession().removeAttribute("CHECKCODE_SERVER");
        //3. 判断
        if (checkcode_server==null || !checkcode_server.equalsIgnoreCase(check)){
            //验证码错误
            //给出提示信息
            ResultInfo info = new ResultInfo();
            info.setFlag(false);
            info.setErrorMsg("验证码错误");
            //4. 将resultInfo 序列化为json
            toJson(response, info);
            //5. 直接return，不再获取数据等操作
            return;
        }



    //1. 获取数据
        Map<String, String[]> map = request.getParameterMap();
        //2. 封装对象,使用BeanUtils.populate
        User user = new User();
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        //3. 调用service注册, 判断数据库是否已经存在，存在返回false
        //UserService userService = new UserServiceImpl();
        boolean registSuccess = userService.regist(user);
        //响应对象：
        ResultInfo resultInfo = new ResultInfo();
        //设置成功或者失败标志
        resultInfo.setFlag(registSuccess);
        //4. 响应结果：
        if(!registSuccess){
            //注册失败：设置提示信息
            resultInfo.setErrorMsg("用户名已存在，注册失败");
        }
        toJson(response, resultInfo);
    }

    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        System.out.println("userServlet 的  find");
        //0. 验证码
        //0.1 先从客户端获取验证码
        String check = request.getParameter("check");
        //0.2 从Session中获取验证码，用于比较
        String checkcode_server = (String) request.getSession().getAttribute("CHECKCODE_SERVER");
        //0.3 得到后移除session
        request.getSession().removeAttribute("CHECKCODE_SERVER");
        //0.4 比较
        if (checkcode_server==null || !checkcode_server.equalsIgnoreCase(check)){
            // 验证码错，给出提示信息
            ResultInfo info = new ResultInfo();
            info.setFlag(false);
            info.setErrorMsg("验证码错误");
            // 转为Json，发送
            toJson(response, info);
            return;
        }


//1. 获取表单数据，封装对象
        //String username = request.getParameter("username");
        //String password = request.getParameter("password");
        Map<String, String[]> parameterMap = request.getParameterMap();
        User user = new User();
        try {
            BeanUtils.populate(user,parameterMap);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
//2. 调用service查询
        //UserService userService = new UserServiceImpl();
        User loginUser = userService.login(user);       //此处只是根据用户名查到User，还要判断密码正确与否
        ResultInfo info = new ResultInfo();
        if (loginUser!=null){
            //2.1 存在，判断密码是否正确
            if (!loginUser.getPassword().equals(user.getPassword())){
                info.setFlag(false);
                info.setErrorMsg("密码不正确");
            }
            //2.2 存在，判断是否激活，
            else {
                if (loginUser.getStatus().equals("Y")){
                    //2.2.1 激活状态，设置后台状态为true，用于跳转页面
                    info.setFlag(true);
                    // 将信息存入session，方面登陆后的页面展示（header.html）
                    request.getSession().setAttribute("user",loginUser);
                }else {
                    info.setFlag(false);
                    info.setErrorMsg("账号未激活！情联系管理员激活！");
                }
            }
        }else {
            //2.2 不存在，登陆失败，给出提示信息
            info.setFlag(false);
            info.setErrorMsg("此账号未注册");
        }
        toJson(response,info);
    }

    /*
          登陆后，通过异步ajax，得到用户名，再index显示 欢迎你。。。
     */
    protected void getUserFromSession(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //从session中获得登陆用户
        Object user = request.getSession().getAttribute("user");
        System.out.println("user = " + user);
        //写回客户端
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getWriter(),user);
    }

    protected void exit(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        //1. 销毁session
        //request.getSession().removeAttribute("user");
        request.getSession().invalidate();
        //2. 跳转页面，使用重定向
        /*
            这是请求转发
            request.getRequestDispatcher("http://localhost/travel/login.html").forward(request,response);
         */
        response.sendRedirect(request.getContextPath()+"/login.html");
    }

    protected void active(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        //1. 获取激活码
        String code = request.getParameter("code");
        //2. 根据激活码判断User是否存在
        //2.1 判断非空
        if (code!=null){
            //UserService us = new UserServiceImpl();
            Boolean flag = userService.active(code);

            //3. 根据标记判断
            String msg = null;
            if (flag){
                //激活成功, 点击超链接，到登陆页面
                msg = "激活成功，请<a href='http://localhost/travel/login.html'>登录</a>";
            }else{
                //激活失败
                msg = "激活失败，请联系管理员";
            }
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write(msg);
        }
    }

}
