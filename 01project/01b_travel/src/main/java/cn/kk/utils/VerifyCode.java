package cn.kk.utils;

import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class VerifyCode {

    public static BufferedImage getImage(String checkCode){


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


        //设置颜色
        g.setColor(Color.YELLOW);
        //设置字体的小大
        g.setFont(new Font("黑体",Font.BOLD,24));
        //图片上写入验证码
        g.drawString(checkCode,15,25);

        return image;
    }

    public static String getCheckCode(){
        String base = "0123456789ABCDEFGHIGKLMNOPQRSTUVWXYZ";
        int size = base.length();
        Random random = new Random();
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < 4; i++) {
            sb.append(base.charAt(random.nextInt(size)));
        }

        return sb.toString();
    }

    public static void noCache(HttpServletResponse response){
        //服务器通知浏览器不要缓存
        response.setHeader("pragma","no-cache");
        response.setHeader("cache-control","no-cache");
        response.setHeader("expires","0");
    }

}
