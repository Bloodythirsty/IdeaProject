package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/*
 生命周期方法：
			       1.  init：服务器启动时执行一次
			       2.  doFilter：每次都会过滤
			       3. destroy：服务器关闭，执行一次
 */

//@WebFilter("/*")
public class Demo04_filter implements Filter {
    public void destroy() {
        System.out.println("demo04 destroy");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("Demo04...走了");
        chain.doFilter(req, resp);
        System.out.println("Demo04 来了");
    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("demo04 init");
    }

}
