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

@WebServlet("/registUserServlet_a")
public class RegistUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//1. 验证码,先从客户端获取
        String check = request.getParameter("check");
        //2. 从Session获取验证码，用于比较从客户端获取到的
        String checkcode_server = (String) request.getSession().getAttribute("CHECKCODE_SERVER");
        //2.1 Session，不然后退有验证码不变
        request.getSession().removeAttribute("CHECKCODE_SERVER");
        //3. 判断
        if (checkcode_server==null || !checkcode_server.equalsIgnoreCase(check)){
            //验证码错误
            //给出提示信息
            ResultInfo info = new ResultInfo();
            info.setFlag(false);
            info.setErrorMsg("验证码错误");
            //4. 将resultInfo 序列化为json
            toJson(response, info);
            //5. 直接return，不再获取数据等操作
            return;
        }



//1. 获取数据
        Map<String, String[]> map = request.getParameterMap();
        //2. 封装对象,使用BeanUtils.populate
        User user = new User();
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        //3. 调用service注册, 判断数据库是否已经存在，存在返回false
        UserService userService = new UserServiceImpl();
        boolean registSuccess = userService.regist(user);
        //响应对象：
        ResultInfo resultInfo = new ResultInfo();
        //设置成功或者失败标志
        resultInfo.setFlag(registSuccess);
        //4. 响应结果：
        if(!registSuccess){
            //注册失败：设置提示信息
            resultInfo.setErrorMsg("用户名已存在，注册失败");
        }
        toJson(response, resultInfo);

    }

    private void toJson(HttpServletResponse response, ResultInfo resultInfo) throws IOException {
        //5. 将resultInfo 序列化为json
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getWriter(), resultInfo);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
