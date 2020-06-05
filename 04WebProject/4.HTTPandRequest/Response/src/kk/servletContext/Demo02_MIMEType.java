package kk.servletContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zkk;
 * @create 2020-03-27;
 */
/*
    1. get the MIME type：
		1. MIME类型：互联网通信过程中定义的一种文件数据类型
		2. 格式：大类型/小类型
			- 如：`text/html` ， `image/jpeg`
		3. 获取：
			- 如：`String getMimeType(String file) `
	2. 域对象：共享数据：
	3. 获取文件（服务器）真实路径：
 */
@WebServlet("/Demo02_MIMEType")
public class Demo02_MIMEType extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = this.getServletContext();
//        1. get the MIME type：
        String fileName = "a.jpg";
        String mimeType = servletContext.getMimeType(fileName);     //   image/jpeg
        System.out.println("mimeType = " + mimeType);
//        2. 域对象：共享数据：
//        3. 获取文件（服务器）真实路径：
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
