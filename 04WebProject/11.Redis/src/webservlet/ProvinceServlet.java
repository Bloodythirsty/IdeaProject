package webservlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import domain.Province;
import service.ProvinceService;
import service.imp.ProvinceServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/provinceServlet")
public class ProvinceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1. 调用查询
        ProvinceService ps = new ProvinceServiceImp();
//        List<Province> list = ps.findAll();
//        //2. 序列化list为json
//        ObjectMapper mapper = new ObjectMapper();
//        //String string = mapper.writeValueAsString(list);
//        //3. 响应
//        response.setContentType("application/json;charset=utf-8");
//        mapper.writeValue(response.getWriter(), list);  //[{"id":1,"name":"北京"},{"id":2,"name":"上海"},{"id":3,"name":"广州"},{"id":4,"name":"陕西"}]

        //优化后
        String provinces = ps.findAllRedis();
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(provinces);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
