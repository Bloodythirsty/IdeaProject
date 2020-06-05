package cn.itcast.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/testSensitiveServlet")
public class testSensitiveServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String msg = request.getParameter("msg");
        System.out.println(name+":"+msg);

        /*
        测试：
                访问这个servlet，uri后面加（?name=kk&msg=你是坏蛋）参数即可，相当于给request传递参数
         */
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
