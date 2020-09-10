package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(value = "/index.jsp")
public class Demo07_chain1 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("demo07_1 执行了");
        chain.doFilter(req, resp);
        System.out.println("demo07_1 执行完了");

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
