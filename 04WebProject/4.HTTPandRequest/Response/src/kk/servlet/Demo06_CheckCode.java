package kk.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * @author zkk;
 * @create 2020-03-27;
 */
@WebServlet("/Demo06_CheckCode")
public class Demo06_CheckCode extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int width = 100;
        int height = 50;

        //1. 创建一个对象，内存中的图片
        BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_3BYTE_BGR); //黑色


        //2. 美化图片
        //2.1 填充背景色
        Graphics g = image.getGraphics();       //画笔对象
        g.setColor(Color.PINK);                 //设置画笔颜色
        g.fillRect(0,0,width,height);    //填充矩形
        //2.2 画边框
        g.setColor(Color.red);                      //设置颜色
        g.drawRect(0,0,width-1,height-1);       //画边框，因为右边和底边边框都画到外面去了，所以减一
        //2.3 写验证码
        //g.drawString("A",20,25);          固定写法
        //2.31动态写法
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        //2.32 生成随机角标
        Random random = new Random();

        for (int i = 1; i < 5; i++) {
            int index = random.nextInt(str.length());
            //2.33 获取随机字符
            char ch = str.charAt(index);
            g.drawString(""+ch,width/5*i,25);
        }

        //2.4 画干扰线
        g.setColor(Color.GREEN);
       // g.drawLine(1,1,30,30);      //两点确定一条直线
        for (int i = 0; i< 5; i++) {
            //2.41 随机生成坐标点
            int x1 = random.nextInt(width);
            int x2 = random.nextInt(width);
            int y1 = random.nextInt(height);
            int y2 = random.nextInt(height);
            g.drawLine(x1,y1,x2,y2);
        }

        //3. 输出到页面
        ImageIO.write(image,"jpg",response.getOutputStream());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
