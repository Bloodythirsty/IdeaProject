package shareInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zkk;
 * @create 2020-03-29;
 */
@WebServlet("/shareCookieInfo")
public class shareCookieInfo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取1Cookie项目下的cookie即可
        Cookie[] cookies = request.getCookies();
        if ( cookies != null){
            for (Cookie cookie: cookies
                 ) {
                System.out.println(cookie.getName() + " :" + cookie.getValue());
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
