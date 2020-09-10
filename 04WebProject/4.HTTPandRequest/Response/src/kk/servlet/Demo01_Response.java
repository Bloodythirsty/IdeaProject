package kk.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zkk;
 * @create 2020-03-27;
 */
/*
在Demo01里面完成重定向，及访问demo01，自动跳转到demo02
 */
@WebServlet("/Demo01_Response")
public class Demo01_Response extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("Demo1...");

        //在Demo01里面完成重定向，及访问demo01，自动跳转到demo02
//        //1. 设置状态码 302
//        resp.setStatus(302);
//        //2. 设置响应头location
//        resp.setHeader("location","/Response_war_exploded/Demo02_Response");

        //简单的重定向方法
        //resp.sendRedirect("/Response_war_exploded/Demo02_Response");  //重定向到内部资源
        //resp.sendRedirect("http://www.baidu.com");  //重定向到外部资源

        //动态获取虚拟目录
        String contextPath = req.getContextPath();
        System.out.println("contextPath = " + contextPath);
        resp.sendRedirect(contextPath+"/Demo02_Response");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
