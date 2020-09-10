package cn.itcast.travel.web.formServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/exitServlet_a")
public class ExitServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 销毁session
        //request.getSession().removeAttribute("user");
        request.getSession().invalidate();
        //2. 跳转页面，使用重定向
        /*
            这是请求转发
            request.getRequestDispatcher("http://localhost/travel/login.html").forward(request,response);
         */
        response.sendRedirect(request.getContextPath()+"/login.html");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
