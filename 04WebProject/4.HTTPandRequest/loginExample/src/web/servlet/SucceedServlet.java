package web.servlet;

import kk.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zkk;
 * @create 2020-03-26;
 */
@WebServlet("/SucceedServlet")
public class SucceedServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User)request.getAttribute("user");
        if (user != null) {
            //给页面设置编码
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("登陆成功，欢迎" + user.getUsername());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
