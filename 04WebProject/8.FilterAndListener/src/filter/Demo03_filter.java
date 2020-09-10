package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
/*
 一般操作
 */
//@WebFilter("/*")
public class Demo03_filter implements Filter {
    public void destroy() {

    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //一般对request消息做增强操作
        System.out.println("demo03 过去了");
        chain.doFilter(req, resp);          //放行回来后，继续执行下面代码
        //一般对response消息做增强操作
        System.out.println("demo03 来了");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
