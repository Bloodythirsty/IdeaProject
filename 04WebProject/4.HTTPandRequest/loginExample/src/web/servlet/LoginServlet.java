package web.servlet;

import dao.UserDao;
import kk.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @author zkk;
 * @create 2020-03-25;
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. 设置编码（username可能中文）
        req.setCharacterEncoding("UTF-8");
//        //2. 获取请求参数
//        String username = req.getParameter("username");
//        String password = req.getParameter("password");
//        //3. 封装user对象
//        User loginUser = new User();
//        loginUser.setUsername(username);
//        loginUser.setPassword(password);

        //2. 获取请求参数
        Map<String, String[]> map = req.getParameterMap();
        //3.1 创建user对象
        User loginUser = new User();
        //3.2 使用BeanUtils封装
        try {
            BeanUtils.populate(loginUser,map);          //传入需要封装的空对象，和接收到的map参数集合
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //4. 调用数据库操作
        UserDao userDao = new UserDao();
        User user = userDao.login(loginUser);   //从数据库中查询到的User
        //5. 判断user
        if (user == null){
            //登陆失败，跳转到failedServlet
            req.getRequestDispatcher("/FailedServlet").forward(req,resp);

        }else {
            //登录成功
            //存储request域数据,跳转到succeedServlet
            req.setAttribute("user",user);
            req.getRequestDispatcher("/SucceedServlet").forward(req,resp);

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
