package cn.itcast.travel.web.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/checkCode")
public class CheckCode extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //服务器通知浏览器不要缓存
        response.setHeader("pragma","no-cache");
        response.setHeader("cache-control","no-cache");
        response.setHeader("expires","0");

        //创建图片
        int width = 80;
        int height = 30;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);

        //获取画笔
        Graphics g = image.getGraphics();
        //画笔设置颜色
        g.setColor(Color.GRAY);
        //填充图片
        g.fillRect(0,0,width,height);

        //产生四个验证码
        String checkCode = getCheckCode();
        //验证码放入Session
        request.getSession().setAttribute("CHECKCODE_SERVER", checkCode);

        //设置颜色
        g.setColor(Color.YELLOW);
        //设置字体的小大
        g.setFont(new Font("黑体",Font.BOLD,24));
        //图片上写入验证码
        g.drawString(checkCode,15,25);

        //将内存中的图片输出到浏览器
        //参数一：图片对象
        //参数二：图片的格式，如PNG,JPG,GIF
        //参数三：图片输出到哪里去
        ImageIO.write(image,"PNG",response.getOutputStream());

    }

    private String getCheckCode(){
        String base = "0123456789";
        int size = base.length();
        Random random = new Random();
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < 4; i++) {
            sb.append(base.charAt(random.nextInt(size)));
        }

        return sb.toString();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
