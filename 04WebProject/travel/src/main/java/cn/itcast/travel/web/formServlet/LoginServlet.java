package cn.itcast.travel.web.formServlet;

import cn.itcast.travel.domain.ResultInfo;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.UserService;
import cn.itcast.travel.service.impl.UserServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/loginServlet_a")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//0. 验证码
        //0.1 先从客户端获取验证码
        String check = request.getParameter("check");
        //0.2 从Session中获取验证码，用于比较
        String checkcode_server = (String) request.getSession().getAttribute("CHECKCODE_SERVER");
        //0.3 得到后移除session
        request.getSession().removeAttribute("CHECKCODE_SERVER");
        //0.4 比较
        if (checkcode_server==null || !checkcode_server.equalsIgnoreCase(check)){
            // 验证码错，给出提示信息
            ResultInfo info = new ResultInfo();
            info.setFlag(false);
            info.setErrorMsg("验证码错误");
            // 转为Json，发送
            toJson(response, info);
            return;
        }


//1. 获取表单数据，封装对象
        //String username = request.getParameter("username");
        //String password = request.getParameter("password");
        Map<String, String[]> parameterMap = request.getParameterMap();
        User user = new User();
        try {
            BeanUtils.populate(user,parameterMap);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
//2. 调用service查询
        UserService userService = new UserServiceImpl();
        //Boolean success = userService.verifyUsnmPswd(username,password);
        User loginUser = userService.login(user);       //此处只是根据用户名查到User，还要判断密码正确与否
        ResultInfo info = new ResultInfo();
        if (loginUser!=null){
            //2.1 存在，判断密码是否正确
            if (!loginUser.getPassword().equals(user.getPassword())){
                info.setFlag(false);
                info.setErrorMsg("密码不正确");
            }
            //2.2 存在，判断是否激活，
            else {
                if (loginUser.getStatus().equals("Y")){
                    //2.2.1 激活状态，设置后台状态为true，用于跳转页面
                    info.setFlag(true);
                    // 将信息存入session，方面登陆后的页面展示（header.html）
                    request.getSession().setAttribute("user",loginUser);
                }else {
                    info.setFlag(false);
                    info.setErrorMsg("账号未激活！情联系管理员激活！");
                }
            }
        }else {
            //2.2 不存在，登陆失败，给出提示信息
            info.setFlag(false);
            info.setErrorMsg("此账号未注册");
        }
        toJson(response,info);
    }

    private void toJson(HttpServletResponse response, ResultInfo info) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        //CharacterFilter已经设置ContentType，表示所有返回资源是html，在这儿再设置一次，表示返回资源是JSON
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getWriter(),info);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
