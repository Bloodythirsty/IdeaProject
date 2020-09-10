package ServletAndRequest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zkk;
 * @create 2020-03-19;
 */
@WebServlet("/Demo04_headers")
public class Demo04_headersReferer extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取referer：即查询从哪儿访问的
        String referer = req.getHeader("referer");      //直接访问/Demo04_headers，访问为null，自己访问自己
        System.out.println("referer :" + referer);          //用login里面的超链接

        //防盗链（用login和daoban两个网页去测试）
        if (referer != null){
            if ( referer.contains("login.html")){
                System.out.println("正常访问");
                resp.setContentType("text/html;charset=utf-8");     //给响应的页面发送消息
                resp.getWriter().write("播放电影");
            }else{
                System.out.println("去login");
                resp.setContentType("text/html;charset=utf-8");
                resp.getWriter().write("去login");
            }

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
