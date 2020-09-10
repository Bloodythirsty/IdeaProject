package servlet;

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

/**
 * @author zkk;
 * @create 2020-03-31;
 */
@WebServlet("/CheckCodeImg")
public class CheckCodeImg extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       int width = 100;
       int height = 50;
        //1. 新建图片
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);

        //2. 画矩形
        Graphics graphics = image.getGraphics();    //画笔
        graphics.setColor(Color.PINK);              //颜色
        graphics.fillRect(0,0,width-1,height-1);

        //3. 动态验证码
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        graphics.setColor(Color.RED);
        StringBuilder sb = new StringBuilder();     //比String+String更高效
        Random random = new Random();
        for (int i = 1; i < 5 ; i++) {
            char ch = str.charAt(random.nextInt(str.length()));
            sb.append(ch);
            graphics.drawString(""+ch,width/5*i,25);
        }
        //存入Session,Session存在服务器，所以不需要response给客户端
        request.getSession().setAttribute("checkCode",sb.toString());

        //4. 画干扰线
        graphics.setColor(Color.GREEN);
        for (int i = 0; i < 6; i++) {
            int x1 = random.nextInt(width);
            int x2 = random.nextInt(width);
            int y1 = random.nextInt(height);
            int y2 = random.nextInt(height);
            graphics.drawLine(x1,y1,x2,y2);
        }

        //5. 输出到页面
        ImageIO.write(image,"jpg",response.getOutputStream());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
