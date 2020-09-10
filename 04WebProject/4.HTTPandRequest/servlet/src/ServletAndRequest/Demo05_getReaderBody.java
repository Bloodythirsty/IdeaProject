package ServletAndRequest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * @author zkk;
 * @create 2020-03-23;
 */
@WebServlet("/Demo05_getReaderBody")
public class Demo05_getReaderBody extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取消息体
        //1. 获取消息流
        BufferedReader reader = request.getReader();
        //2. 读数据
        String line = null;
        while (( line = reader.readLine()) != null){
            System.out.println(line);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
