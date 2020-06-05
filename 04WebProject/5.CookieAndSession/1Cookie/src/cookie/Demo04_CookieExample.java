package cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zkk;
 * @create 2020-03-29;
 */
/*
        1. 需求：
             案例需求：
                1. 访问一个Servlet，如果是第一次访问，则提示：您好，欢迎您首次访问。
                2. 如果不是第一次访问，则提示：欢迎回来，您上次访问时间为:显示时间字符串
		2. 分析：
			1. 采用cookie来完成
			2. 服务器判断是否有名为：lastTime的cookie
				1. 有，不是第一次访问
				2. 没有，是第一次访问
			3. 无论是否是第一次，把访问时间存进cookie
 */
@WebServlet("/Demo04_CookieExample")
public class Demo04_CookieExample extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 获取所有cookie，判断是否有lastTime的cookie
        Cookie[] cookies = request.getCookies();
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        boolean flag = false;
        if ( cookies != null && cookies.length > 0){
            for (Cookie ck: cookies
                 ) {
                //存在其他cookie的情况下，如果有lastTime的Cookie
                if ( ck.getName().equals("lastTime")){
                    flag = true;
                    nextVisit(writer, ck,response);
                //    System.exit(1);       思路，找到结束程序。但这样会结束服务器。
                }
                //存在其他cookie的情况下，如果没有lastTime的Cookie。
                //但如果要找的cookie在后面，前面几次就会多次添加同一个cookie，不可取
//                else {
//                    firstVisit(response, writer);
//                }
            }
        }
        //cookies为空，或者 没找到，
        if ( cookies == null || cookies.length==0 || !flag){
            firstVisit(response, writer);
        }
    }

    private void nextVisit(PrintWriter writer, Cookie ck,HttpServletResponse response) throws UnsupportedEncodingException {
        //解码,取出来先解码
        String decode = URLDecoder.decode(ck.getValue(), "utf-8");
        System.out.println("url解码后 next = " + decode);
        writer.write("欢迎再次回来，您上次的访问时间为：" + decode);

        String str_date = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss").format(new Date());
        //编码
        System.out.println("url编码前 next = " + str_date);
        String encode = URLEncoder.encode(str_date, "UTF-8");
        System.out.println("url编码后 next = " + encode);
        ck.setValue(encode);
        response.addCookie(ck);
    }

    private void firstVisit(HttpServletResponse response, PrintWriter writer) throws UnsupportedEncodingException {
        writer.write("欢迎首次访问！");
        String str_date = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss").format(new Date());

        System.out.println("url编码前 first = " + str_date);
        // URL编码
        String encode = URLEncoder.encode(str_date, "UTF-8");
        System.out.println("url编码后 first = " + encode);


        Cookie lastTimeCookie = new Cookie("lastTime",encode);
        response.addCookie(lastTimeCookie);
    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
