package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@WebFilter("/index.jsp")  //1. 具体资源配置
//@WebFilter("/servlet/*")  //2. 目录拦截
//@WebFilter("*.jsp")  // 3.后缀名拦截
public class Demo05_filterConfig implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("Demo05 ...");

        //1. 具体资源配置
        //不放行，则index.jsp不能被访问，helloJsp则可以
        //chain.doFilter(req, resp);

        //2. 目录拦截，访问servlet下面的会输出Demo05

        //3.后缀名拦截
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
