package filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
/*
在XML里面配置Filter
 */
public class Demo02_filterXML implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("DEMO02 doFilter 被执行了");

        //考虑是否放行
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
