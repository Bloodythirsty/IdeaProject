package kk.servlet;

import javax.servlet.ServletException;
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
@WebServlet("/Demo04_OutputCharacter")
public class Demo04_OutputCharacter extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        //0.1 已知浏览器编码，设置编码即可
//        response.setCharacterEncoding("GBK");

        //0.2 不知浏览器编码
        //response.setHeader("Content-Type","text/html;charset=utf-8");
        response.setContentType("text/html;charset=gbk");


        //1. 获取输出流
        PrintWriter pw = response.getWriter();
//        //设置编码
//        response.setContentType("text/html;charset=utf-8");
        //2. 写入
        pw.write("已经访问Demo03");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
