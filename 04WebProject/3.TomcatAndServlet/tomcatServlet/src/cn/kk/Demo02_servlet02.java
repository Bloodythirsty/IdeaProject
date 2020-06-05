package cn.kk;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author zkk;
 * @create 2020-03-17;
 */
public class Demo02_servlet02 implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("Demo02 init");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("Demo02 service");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("Demo02 destory");
    }
}
