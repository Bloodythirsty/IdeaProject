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
cookie：
存活时间

 */
@WebServlet("/Demo03_CookieMaxAge")
public class Demo03_CookieMaxAge extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 新建cookie
        Cookie cookie = new Cookie("zhang", "kang");
        //2. 设置cookie，即关闭浏览器后，300秒内还能访问
        cookie.setMaxAge(300);
        //3. 发送cookie,让Demo02取接受
        response.addCookie(cookie);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
