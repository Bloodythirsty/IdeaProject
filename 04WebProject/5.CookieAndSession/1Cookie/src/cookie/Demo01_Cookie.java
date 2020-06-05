package cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zkk;
 * @create 2020-03-28;
 */

/*
cookie快速入门
1. 先访问demo1，在访问demo2
2. 用另一个浏览器直接访问Demo2，拿不到数据，因为没有和Demo01建立会话
 */
@WebServlet("/Demo01_Cookie")
public class Demo01_Cookie extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 创建cookie
        Cookie cookie = new Cookie("msg","hellocookie");
        Cookie cookie1 = new Cookie("msg1","hellocookie1");
        cookie.setPath("/");                //为了让11CookieShareInfo能共享
        //2. 发送cookie
        response.addCookie(cookie);
        response.addCookie(cookie1);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
