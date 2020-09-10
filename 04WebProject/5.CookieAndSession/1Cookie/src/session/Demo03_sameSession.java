package session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @author zkk;
 * @create 2020-03-29;
 */
@WebServlet("/Demo03_sameSession")
public class Demo03_sameSession extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //使用session获取数据
        //1. 获取session
        HttpSession session = request.getSession();
        System.out.println("session = " + session);
        //期望客户端关闭后，session也能相同
        Cookie c = new Cookie("JSESSIONID",session.getId());
        c.setMaxAge(60*5);
        response.addCookie(c);
        //2. 获取数据
        String msg = (String) session.getAttribute("msg");
        System.out.println("msg = " + msg);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
