package ServletAndRequest;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * @author zkk;
 * @create 2020-03-24;
 */
@WebServlet("/Demo10_servletContext")
public class Demo10_servletContext extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取servletContext
        ServletContext servletContext = req.getServletContext();
        System.out.println("servletContext = " + servletContext);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);   //post和get方法里面的代码相同，则可写一份，调用另一个即可
    }
}
