package filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@WebFilter("/*")        //访问所以资源，都会过滤
public class Demo01_filter implements Filter {

    /*
    执行顺序：
        init：服务器启动时执行一次
        doFilter：每次都会过滤
        destroy：服务器关闭，执行一次
     */

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("doFilter 被执行了");

        //考虑是否放行
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
