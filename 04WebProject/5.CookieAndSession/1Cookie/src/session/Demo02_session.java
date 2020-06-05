package session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author zkk;
 * @create 2020-03-29;
 */
@WebServlet("/Demo02_session")
public class Demo02_session extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //使用session获取数据
        //1. 获取session
        HttpSession session = request.getSession();
        //2. 获取数据
        String msg = (String) session.getAttribute("msg");
        System.out.println("msg = " + msg);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
