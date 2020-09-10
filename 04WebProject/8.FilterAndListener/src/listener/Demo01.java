package listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

@WebListener
public class Demo01 implements ServletContextListener,
        HttpSessionListener, HttpSessionAttributeListener {

    // Public constructor is required by servlet spec
    public Demo01() {
    }

    public void contextInitialized(ServletContextEvent sce) {

        System.out.println("servletContext created");
        //1. 一般用于加载文件资源
        //1.1 获取ServletContext对象
        ServletContext servletContext = sce.getServletContext();

        //2. 加载资源文件
        String contextConfigLocation = servletContext.getInitParameter("contextConfigLocation");
        //3. 获取真实路径
        String realPath = servletContext.getRealPath(contextConfigLocation);
        //4. 加载进内存
        try {
            BufferedReader bf = new BufferedReader(new FileReader(realPath));
            System.out.println(bf);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void contextDestroyed(ServletContextEvent sce) {

        System.out.println("servletContext destroy");
    }

    // -------------------------------------------------------
    // HttpSessionListener implementation
    // -------------------------------------------------------
    public void sessionCreated(HttpSessionEvent se) {
        /* Session is created. */
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        /* Session is destroyed. */
    }

    // -------------------------------------------------------
    // HttpSessionAttributeListener implementation
    // -------------------------------------------------------

    public void attributeAdded(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute 
         is added to a session.
      */
    }

    public void attributeRemoved(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute
         is removed from a session.
      */
    }

    public void attributeReplaced(HttpSessionBindingEvent sbe) {
      /* This method is invoked when an attibute
         is replaced in a session.
      */
    }
}
