package cn.itcast.web.servlet;

import cn.itcast.domain.User;
import cn.itcast.service.UserService;
import cn.itcast.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 设置编码
        request.setCharacterEncoding("utf-8");
        //2. 获取数据
        //2.1 获取验证码
        String verifycode = request.getParameter("verifycode");
        //2.2 验证码校验
        String checkcode_server = (String) request.getSession().getAttribute("CHECKCODE_SERVER");
        if (!checkcode_server.equalsIgnoreCase(verifycode)) {
            //验证码不正确，提示，跳转
            request.setAttribute("login_err_msg", "验证码错误！");                //验证码和密码错误属于同一类消息
            request.getRequestDispatcher("/login.jsp").forward(request, response);
            return;
        }
        //删除验证码,保证一次性
        request.getSession().removeAttribute("CHECKCODE_SERVER");
        //2.1 获取用户数据
        Map<String, String[]> parameterMap = request.getParameterMap();
        User user = new User();
        //3. 封装User对象
        try {
            BeanUtils.populate(user, parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //4. 调用查询
        UserService service = new UserServiceImpl();
        User loginUser = service.login(user);

        //5. 判断登录是否成功
        if (null != loginUser) {
            ////5.2 登录成功，存入session，跳转页面(重定向，request不能共享数据，只能session)
            request.getSession().setAttribute("user", loginUser);
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        } else {
            //5.1 登录失败，跳转到login页面（跳转要提示信息，用请求转发，request提供信息）
            request.setAttribute("login_err_msg","用户名密码错误");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
