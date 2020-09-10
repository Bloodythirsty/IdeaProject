package ServletAndHttp;

import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zkk;
 * @create 2020-03-18;
 */

//@WebServlet({"/demo04","/demo041","/demo042"})
//@WebServlet("/user/demo04")
//@WebServlet("/user/*")      //* 通配符 任意写
//@WebServlet("/*")
@WebServlet("*.do")
public class Demo04_urlPatterns extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("demo04 HTTP HttpServlet urlPatterns");
        System.out.println(req);
    }
}
