package cn.itcast.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/*
用户名敏感词汇过滤：
 */
@WebFilter("/*")
public class sensitiveWordFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //1. 创建req代理对象，增强getParameter方法
        ServletRequest proxy_req = (ServletRequest)Proxy.newProxyInstance(req.getClass().getClassLoader(), req.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (method.getName().equals("getParameter")){
                    String value = (String)method.invoke(req,args);
                    //从敏感词汇.txt里面读取判断,在init里面加载,用list循环判断
                    if (value != null) {
                        for (String s:list) {
                            if (value.contains(s)){
                                value = value.replaceAll(s, "***");
                            }
                        }
                    }
                    return value;
                }
                return method.invoke(req,args);
            }
        });
        //2. 放行，记得传入代理req，而不是原来的
        chain.doFilter(proxy_req, resp);
    }

    private List<String> list = new ArrayList<String>();    //存放敏感词汇
    public void init(FilterConfig config) throws ServletException {
        try {
            //获取服务器src下的文件
            String realPath = config.getServletContext().getRealPath("/WEB-INF/classes/敏感词汇.txt");
            BufferedReader br = new BufferedReader(new FileReader(realPath));
            String t ;
            while(( t = br.readLine()) != null){
                list.add(t);
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(list);
    }

}
