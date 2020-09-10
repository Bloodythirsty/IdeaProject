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
@WebServlet("/Demo07_get")
public class Demo07_chineseGarbageCharacters extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //get获取参数
        //1. 设置流的编码
        req.setCharacterEncoding("utf-8");
        //1. 根据参数名称获取参数值。
        String parameter = req.getParameter("username");
        System.out.println(" username = " + parameter);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);   //post和get方法里面的代码相同，则可写一份，调用另一个即可
    }
}
