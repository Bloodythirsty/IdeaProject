package ServletAndRequest;

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
@WebServlet("/Demo09_forward")
public class Demo09_forward extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //Demo08中设置属性值，Demo09中获取属性值
        Object get =  req.getAttribute("msg");
        System.out.println("get = " + get);
        System.out.println("Demo099999");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);   //post和get方法里面的代码相同，则可写一份，调用另一个即可
    }
}
