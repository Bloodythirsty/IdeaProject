package cn.kk.controller;

import cn.kk.exception.SysException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/user")
public class UserController {

    @RequestMapping(path = "textException")
    public String testException() throws Exception {
        System.out.println("TestException");

        try {
            // 模拟异常
            int i = 1/0;
        } catch (Exception e) {
            //控制台打印
            e.printStackTrace();
            // 抛出自定义异常
            throw new SysException("出现错误");
        }

        return "success";
    }
}
