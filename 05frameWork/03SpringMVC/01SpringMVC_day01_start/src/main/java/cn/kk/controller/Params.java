package cn.kk.controller;

import cn.kk.domain.DateParam;
import cn.kk.domain.Student;
import cn.kk.domain.User;
import cn.kk.utils.StringToDate;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Map;

@Controller
@RequestMapping("/params")
@SessionAttributes(value = {"msg"})     //把msg=mm存入了session域
public class Params {

    @RequestMapping(path = {"/testParams"})
    public String testParameters(String username, String password){
        System.out.println("parmars testing");
        System.out.println("username = " + username);
        System.out.println("password = " + password);
        return "success";
    }

    @RequestMapping(path = "/beanParams")       //params.jsp
    public String beanParamater(User user){
        System.out.println("user = " + user);
        return "success";
    }

    @RequestMapping(path = "/dateParam")            //date.jsp
    public String dateParam(DateParam date){
        System.out.println("date = " + date);
        return "success";
    }

    @RequestMapping(path = "/testAPI")          //date.jsp
    public String testAPI(HttpServletRequest request, HttpServletResponse response){
        System.out.println(request);
        System.out.println(response);
        System.out.println(request.getSession());
        System.out.println(request.getSession().getServletContext());
        return "success";
    }

    @RequestMapping(path = "/testRequestParam")         //对应anno.jsp
    public String testRequestParam(@RequestParam(value = "username",required = false) String name){
        System.out.println("name = " + name);
        return "success";
    }

    @RequestMapping(path = "/testRequestBody")         //对应anno.jsp
    public String testRequestBody(@RequestBody String body){
        System.out.println("body = " + body);
        return "success";
    }

    @RequestMapping(path = "/testPathVariable/{sid}")         //对应anno.jsp
    public String testPathVariable(@PathVariable(name = "sid") String id){
        System.out.println("id = " + id);
        return "success";
    }

    @RequestMapping(path = "/testRequestHeader")         //对应anno.jsp
    public String testRequestHeader( @RequestHeader(value = "Accept") String header){
        System.out.println("header = " + header);
        return "success";
    }

    @RequestMapping(path = "/testCookieValue")         //对应anno.jsp
    public String testCookieValue( @CookieValue(value = "JSESSIONID") String cookie){
        System.out.println("cookie = " + cookie);
        return "success";
    }


    // @RequestMapping(path = "/testModelAttribute")         //对应anno.jsp
    // public String testModelAttribute( Student student){
    //     System.out.println("testModelAttribute");
    //     System.out.println("student = " + student);
    //     return "success";
    // }

    /*
            该方法会先执行
     */
    // @ModelAttribute
    // public Student showUser(String name){
    //     System.out.println("show Student");
    //     // 通过用户名查数据库（模拟）
    //     Student student = new Student();
    //     student.setName("康康");
    //     student.setSex("男");
    //     student.setAge("13");
    //     return student;
    // }

    @RequestMapping(path = "/testModelAttribute")         //对应anno.jsp
    public String testModelAttribute(@ModelAttribute(name = "first") Student student){
        System.out.println("testModelAttribute");
        System.out.println("student = " + student);
        return "success";
    }


    @ModelAttribute
    public void showUser(String name, Map<String,Student> map){
        System.out.println("show Student");
        // 通过用户名查数据库（模拟）
        Student student = new Student();
        student.setName("康康");
        student.setSex("男");
        student.setAge("13");
        map.put("first",student);
    }

    @RequestMapping(path = "/testSessionAttributes")
    public String testSessionAttributes(Model model){
        System.out.println("sessionAttribute");
        model.addAttribute("msg","mm");     //给request域存入
        return "success";
    }

    @RequestMapping(path = "/getSessionAttributes")
    public String getSessionAttributes(ModelMap modelMap){
        System.out.println("GetSessionAttribute");
        String msg = (String)modelMap.get("msg");
        System.out.println("从session取值：msg = " + msg);
        return "success";
    }

    @RequestMapping(path = "/removeRequestAttribute")
    public String removeRequestAttribute(ModelMap modelMap){
        System.out.println("removeRequestAttribute");
        modelMap.remove("msg");
        String msg = (String)modelMap.get("msg");
        System.out.println("从model取值：msg = " + msg);
        return "success";
    }

    @RequestMapping(path = "/removeSessionAttribute")
    public String removeSessionAttribute(SessionStatus status){
        System.out.println("removeSessionAttribute");
        status.setComplete();                           //删除session中的数据
        return "success";
    }
}
