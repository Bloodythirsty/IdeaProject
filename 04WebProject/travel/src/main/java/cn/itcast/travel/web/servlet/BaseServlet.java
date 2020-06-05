package cn.itcast.travel.web.servlet;

import cn.itcast.travel.domain.ResultInfo;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BaseServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("baseServlet的servlet");
        //1. 完成方法的分发
        //1.1 获取请求路径
        String uri = req.getRequestURI();
        System.out.println("uri = " + uri);     //  /travel/user/add
        //1.2 获取方法名称
        String methodName = uri.substring(uri.lastIndexOf("/") + 1);
        System.out.println("method = " + methodName);   // method = add
        //1.3 获取方法对象method
        System.out.println(this);   //谁调用service，this就是谁
        try {
            Method method = this.getClass().getDeclaredMethod(methodName,HttpServletRequest.class,HttpServletResponse.class);
            //暴力反射
            method.setAccessible(true);
            //1.4 执行方法
            method.invoke(this,req,resp);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }


    }


    protected void toJson(HttpServletResponse response, Object ob) throws IOException {
        //5. 将resultInfo 序列化为json
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getWriter(), ob);
    }
}
