package kk.servletContext;

import javax.servlet.ServletContext;
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
    1. 通过request对象获取
		- `request.getServletContext();`
	2. 通过HttpServlet
		- `this.getServletContext();`
 */
@WebServlet("/Demo01_ServletContext")
public class Demo01_ServletContext extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        1. 通过request对象获取
        ServletContext servletContext1 = request.getServletContext();
        //        2. 通过HttpServlet
        ServletContext servletContext2 = this.getServletContext();
        System.out.println("servletContext1 = " + servletContext1);
        System.out.println("servletContext2 = " + servletContext2);
        System.out.println(servletContext1 == servletContext2);         //比较引用数据类型，不重写equals情况下，==和equals方法一样，比较的是地址值
        System.out.println(servletContext1.equals(servletContext2));

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
