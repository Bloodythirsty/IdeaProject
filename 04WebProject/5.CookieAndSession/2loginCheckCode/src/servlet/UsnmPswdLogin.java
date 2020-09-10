package servlet;

import bean.User;
import dao.UserDao;
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
 * @create 2020-03-31;
 */
@WebServlet("/UsnmPswdLogin")
public class UsnmPswdLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 获取账号密码,封装。使用BeanUtils简化操作
        Map<String, String[]> parameterMap = request.getParameterMap();
        User loginUser = new User();
        try {
            BeanUtils.populate(loginUser, parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //3. 查询，不存在user为空
        User user = new UserDao().login(loginUser);

        //4. 判断
        if (user == null){
            //4.1 失败服务
            //request.getRequestDispatcher("/FailedLogin").forward(request,response);   //一般这样做
            //另一种方法，设置request域，再jsp中获取
            request.setAttribute("err_user","用户名或密码错误");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }else {
            //4.2 成功服务
            request.setAttribute("user",user);
            request.getRequestDispatcher("/SucceedLogin").forward(request,response);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
