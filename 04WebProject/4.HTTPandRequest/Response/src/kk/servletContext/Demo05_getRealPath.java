package kk.servletContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

/**
 * @author zkk;
 * @create 2020-03-27;
 */
/*
	3. 获取文件（服务器）真实路径：
	    加载b.txt进内存，需要创建File,所以需要真实路径
 */
@WebServlet("/Demo05_getRealPath")
public class Demo05_getRealPath extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = this.getServletContext();

        //1. web目录下的文件
        String realPathB = servletContext.getRealPath("/b.txt");
        System.out.println("realPath = " + realPathB);

        //2. web -> WEB-INF 目录下的文件
        String realPathC = servletContext.getRealPath("/WEB-INF/c.txt");
        System.out.println("realPathC = " + realPathC);

        //3. src 目录下的文件，又被放置在/WEB-INF/classes/下，所以这样获取
        String realPathA = servletContext.getRealPath("/WEB-INF/classes/a.txt");
        System.out.println("realPathA = " + realPathA);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
