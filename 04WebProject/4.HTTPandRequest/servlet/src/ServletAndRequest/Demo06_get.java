package ServletAndRequest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

/**
 * @author zkk;
 * @create 2020-03-24;
 */
@WebServlet("/Demo06_get")
public class Demo06_get extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //get获取参数
        //1. 根据参数名称获取参数值。
//        String parameter = req.getParameter("password");
//        System.out.println("GET parameter = " + parameter);
//
//
//        //2. 根据参数名称获取参数值数组
//        System.out.println("------------------");
//        String[] hobbies = req.getParameterValues("hobby");
//        for(String e:hobbies) {
//            System.out.println("e = " + e);
//        }

        //3. 获取所有请求的参数名称
//        System.out.println("------------------");
//        Enumeration<String> parameterNames = req.getParameterNames();
//        while ( parameterNames.hasMoreElements()){
//            String name = parameterNames.nextElement();
//            String value = req.getParameter(name);
//            System.out.println(name + "=" +  value);
//
//        }

        //4. 获取所有parameter的键值对
        System.out.println("------------------");
        Map<String, String[]> parameterMap = req.getParameterMap();
        Set<String> keySet = parameterMap.keySet();
        for(String name:keySet){
            String[] values = parameterMap.get(name);
            for (String value:values){
                System.out.println(name + "=" + value);
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //post获取参数
//        //1. 根据参数名称获取参数值。
//        String parameter = req.getParameter("password");
//        System.out.println("POST parameter = " + parameter);

        this.doGet(req,resp);   //post和get方法里面的代码相同，则可写一份，调用另一个即可
    }
}
