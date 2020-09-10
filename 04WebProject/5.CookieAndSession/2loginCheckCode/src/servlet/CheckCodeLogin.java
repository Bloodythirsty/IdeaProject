package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zkk;
 * @create 2020-03-31;
 */
@WebServlet("/CheckCodeLogin")
public class CheckCodeLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 获取验证码
        String checkCode = request.getParameter("checkCode");
        //2. 获取checkCodeImg里面存的Session
        String checkCode_Session = (String)request.getSession().getAttribute("checkCode");

        //获取后删除，不然后退后不刷新验证码
        request.getSession().removeAttribute("checkCode");

        //3. 忽略大小写进行验证(生成的验证码不为空，放前面，防止空指针异常///删除后，重新登录，空指针异常，所以判断)
        if (checkCode_Session != null && checkCode_Session.equalsIgnoreCase(checkCode)){
            //3.1 验证码正确，比较账号密码
            System.out.println("验证码正确");
            request.getRequestDispatcher("/UsnmPswdLogin").forward(request,response);
        }else {
            //3.2 验证码不正确
            //  1. 提示信息存储信息到request，用于转发时共享
            //  2. 转发到登录的网页login.html
            request.setAttribute("err_checkCode","验证码错误");
            System.out.println("验证码错");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
