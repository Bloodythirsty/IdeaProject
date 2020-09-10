package cn.kk.controller;

import cn.kk.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Controller
@RequestMapping(path = "/user")
public class UserController {

    @RequestMapping(path = "/testString")
    public String testString(Model model){
        System.out.println("testString");
        // 模拟取数据，在页面上展示
        User user = new User();
        user.setName("mm");
        user.setSex("男");
        user.setAge(11);
        model.addAttribute("firstUser",user);       //存入request域
        return "success";
    }

    /*
            请求转发：一次请求，路径不用谢项目名
            重定向：两次请求，要写路径名
     */
    @RequestMapping(path = "/testVoid")
    public void testVoid(Model model, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("testVoid");
        // 1.  请求转发，不会经过视图解析器，所以不能光写名字。
        // request.getRequestDispatcher("/pages/success.jsp").forward(request,response);

        //2. 重定向
        // System.out.println(request.getContextPath());
        // response.sendRedirect(request.getContextPath()+"/index.jsp");
        // 重定向，不能直接访问WEB-INF下的资源
        // response.sendRedirect(request.getContextPath()+"/WEB-INF/succeed.jsp");

        //3. 直接响应：
        response.setCharacterEncoding("utf-8");                 //输入Response容器的时候，用的编码
        response.setContentType("text/html;charset=utf-8");         // 浏览器解析的编码（同时默认了，response响应流的编码）
        response.getWriter().println("直接响应");
    }


    @RequestMapping(path = "/testModelAndView")
    public ModelAndView testString(){
        System.out.println("testModelAndView");
        // 创建ModelAndView对象
        ModelAndView mv = new ModelAndView();
        User user = new User();
        user.setName("modelAndView");
        user.setSex("男");
        user.setAge(11);
        // 存入mv对象
        mv.addObject("firstUser",user);     // 因为ModelAndView，存入的时候是ModelMap，所以也会存入request域
        // 设置viewName, 会用视图解析器解析，只需写jsp名
        mv.setViewName("success");
        return mv;
    }

    @RequestMapping(path = "/testForwardOrRedirect")
    public String testForwardOrRedirect(){
        System.out.println("testForwardOrRedirect");
        // 请求转发
        // return "forward:/WEB-INF/succeed.jsp";

        //重定向

        return "redirect:/pages/success.jsp";
    }


    @RequestMapping(path = "/testAjax")
    public @ResponseBody User testAjax(@RequestBody User user){
        System.out.println("testString");
        // 有了jackson包，SpringMVC会自动将json字符串封装为bean
        System.out.println("user = " + user);

        //响应，模拟查询数据库
        user.setName("修改");
        return user;
    }
}
