package Demo01;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/findUsernameServlet")
public class FindUsernameServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 获取ajax设置的数据
        String username = request.getParameter("username");

        //期望得到的参数：  {“userExist”:true, "msg":"用户名已存在，换一个"}
        //              {“userExist”:false, "msg":"用户名可用"}
        //2. 则用Map
        Map<String,Object> map = new HashMap<>();
        if (username.equals("zhangsan")){
            map.put("userExist",true);
            map.put("msg","用户名已存在，换一个");
        }else{
            map.put("userExist",false);
            map.put("msg","用户名可用");
        }
        //3. 转JS
        response.setContentType("application/json;charset=utf-8"); //设置编码
        ObjectMapper mapper = new ObjectMapper();
        // String json = mapper.writeValueADString(map);
        // response.getWriter.writer(json);
        mapper.writeValue(response.getWriter(),map);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
