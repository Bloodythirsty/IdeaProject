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

 */
@WebServlet("/Demo02_Cookie")
public class Demo02_Cookie extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //3. 接收cookie
        Cookie[] cookies = request.getCookies();

        if ( cookies != null){
            for (Cookie c: cookies
            ) {
                System.out.println(c.getName() + " : " + c.getValue());
            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
