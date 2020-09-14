package cn.kk.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/springboot")
public class QuickController {

    @RequestMapping(path = "/quick")
    @ResponseBody       //直接给页面返回字符串，return不解析成页面路径
    public String quick(){
        return "hello springBoot 111  dd ";
    }
}
