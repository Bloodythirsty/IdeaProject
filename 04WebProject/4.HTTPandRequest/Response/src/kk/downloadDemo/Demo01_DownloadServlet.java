package kk.downloadDemo;

import kk.utils.DownLoadUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * @author zkk;
 * @create 2020-03-28;
 */
@WebServlet("/Demo01_DownloadServlet")
public class Demo01_DownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 获取请求参数
        String filename = request.getParameter("filename");
        //2. 使用字节流输入楼加载文件
        //2.1 获取文件真实路径
        ServletContext servletContext = this.getServletContext();
        String filePath = servletContext.getRealPath("/img/" + filename);
        //2.2 加载进内存
        FileInputStream fis = new FileInputStream(filePath);
        //3. 设置响应头
        //3.1 响应头类型：content-type
        String filenameMime = servletContext.getMimeType("filename"); //获取MIME类型，contentType使用
        response.setContentType(filenameMime);

        //解决中文文件名问题
//        //1. 获取user-agent 头参数
//        String agent = request.getParameter("user-agent");
//        //2. 使用utils里面的下载工具类
//        filename = DownLoadUtils.getFileName(agent, filename);
        filename = URLEncoder.encode(filename, "utf-8");


        //3.2 设置以附件形式打开：content-disposition
        response.setHeader("content-disposition","attachment;filename="+filename);
        //4. 将输入流的数据写入到输出流中
        ServletOutputStream outputStream = response.getOutputStream();
        byte[] by = new byte[1024*8];
        int len = 0;
        while ((len = fis.read(by)) != -1){
            outputStream.write(by,0,len);
        }
        fis.close();
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
