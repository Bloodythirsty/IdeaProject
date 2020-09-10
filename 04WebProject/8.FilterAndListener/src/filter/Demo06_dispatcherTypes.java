package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//1. 浏览器直接请求资源时，会被拦截，即访问demo02servlet console不会输出
//@WebFilter(value = "/index.jsp", dispatcherTypes = DispatcherType.REQUEST)
//2. 请求转发会被拦截，即访问demo02servlet console会输出
//@WebFilter(value = "/index.jsp", dispatcherTypes = DispatcherType.FORWARD)
// 3. 配置多个值
//@WebFilter(value = "/index.jsp", dispatcherTypes = {DispatcherType.REQUEST, DispatcherType.FORWARD})
//@WebFilter(value = "/*", dispatcherTypes = {DispatcherType.REQUEST, DispatcherType.FORWARD})    //过滤器执行了两次
public class Demo06_dispatcherTypes implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("demo06");
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
