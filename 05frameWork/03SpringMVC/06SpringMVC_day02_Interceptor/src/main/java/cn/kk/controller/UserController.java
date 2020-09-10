package cn.kk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/user")
public class UserController {

    @RequestMapping(path = "/textInterceptor")
    public String textInterceptor()  {
        System.out.println("textInterceptor");
        return "success";
    }
}
