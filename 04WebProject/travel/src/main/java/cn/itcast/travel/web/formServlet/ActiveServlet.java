package cn.itcast.travel.web.formServlet;

import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.UserService;
import cn.itcast.travel.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/activeServlet_a")
public class ActiveServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 获取激活码
        String code = request.getParameter("code");
        //2. 根据激活码判断User是否存在
        //2.1 判断非空
        if (code!=null){
            UserService us = new UserServiceImpl();
            Boolean flag = us.active(code);

            //3. 根据标记判断
            String msg = null;
            if (flag){
                //激活成功, 点击超链接，到登陆页面
                msg = "激活成功，请<a href='http://localhost/travel/login.html'>登录</a>";
            }else{
                //激活失败
                msg = "激活失败，请联系管理员";
            }
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write(msg);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
