package cn.itcast.web.servlet;

import cn.itcast.domain.PageBean;
import cn.itcast.domain.User;
import cn.itcast.service.UserService;
import cn.itcast.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/findUserByPageServlet")
public class findUserByPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1. 设置编码
        request.setCharacterEncoding("utf-8");
        //1. 获取请求参数，rows和currentPage
        String rows = request.getParameter("rows");
        String currentPage = request.getParameter("currentPage");

        // 判断rows和currentPage是否合规
        if (currentPage == null || "".equals(currentPage)){
            currentPage = "1";
        }
        if (rows == null || "".equals(rows)){
            rows = "5";
        }

        //获取条件查询参数
        Map<String, String[]> condition = request.getParameterMap();

        //2. 调用service查询
        UserService userService = new UserServiceImpl();
        PageBean<User> pb = userService.findUserByPage(currentPage,rows,condition);
        //3. 存入
        request.setAttribute("pb",pb);
        request.setAttribute("condition",condition);      //用于查询的回显
        //4. 转发
        request.getRequestDispatcher("/list.jsp").forward(request,response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
