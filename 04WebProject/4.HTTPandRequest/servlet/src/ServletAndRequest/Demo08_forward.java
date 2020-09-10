package ServletAndRequest;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;


/**
 * @author zkk;
 * @create 2020-03-24;
 */
@WebServlet("/Demo08_forward")
public class Demo08_forward extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Demo08888888");

        //转发前存储数据
        req.setAttribute("msg","hello");

        //转发到demo9资源
//        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/Demo09_forward");
//        requestDispatcher.forward(req,resp);
        req.getRequestDispatcher("/Demo09_forward").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);   //post和get方法里面的代码相同，则可写一份，调用另一个即可
    }
}
