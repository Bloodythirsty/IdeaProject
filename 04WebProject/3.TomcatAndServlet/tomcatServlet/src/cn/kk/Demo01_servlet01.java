package cn.kk;

/**
 * @author zkk;
 * @create 2020-03-15;
 */

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * 快速入门
 */
// @WebServlet("/demo01")
public class Demo01_servlet01 implements Servlet {

    /**
     初始化方法，在servlet执行时，只执行一次
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init...");
    }

    /*
    获取servletConfig对象，即配置对象，需自己实现
     */
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    //提供服务的方法
    /*
        每次servlet被访问时，执行，执行多次
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("Hello Servlet");
    }

    /*
    获取servlet信息，作者版本等。
     */
    @Override
    public String getServletInfo() {
        return null;
    }

    /*
        销毁方法
        在servelet正常关闭时，执行一次。（非正常关闭不会执行）
     */
    @Override
    public void destroy() {
        System.out.println("destory");
    }
}
