package kk.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author zkk;
 * @create 2020-03-27;
 */
@WebServlet("/Demo05_OutputStream")
public class Demo05_OutputStream extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");
        //获取字节流
        ServletOutputStream outputStream = response.getOutputStream();
        outputStream.write("你好Demo05".getBytes("utf-8"));   //一般用于输出图片

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
