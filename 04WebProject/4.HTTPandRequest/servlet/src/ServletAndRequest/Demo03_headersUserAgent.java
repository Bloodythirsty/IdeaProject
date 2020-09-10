package ServletAndRequest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @author zkk;
 * @create 2020-03-19;
 */
@WebServlet("/Demo03_headers")
public class Demo03_headersUserAgent extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取user-agent
        String agent = req.getHeader("user-agent");
        if (agent.contains("Chrome")){
            System.out.println("chrome");
        }else if (agent.contains("Ie")){

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
