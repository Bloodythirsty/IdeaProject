package cn.kk.controller;

import cn.kk.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Slf4j
@RequestMapping("/test")
@Controller
public class Controller1 {

    @RequestMapping("/demo01")
    public String testDemo01(){
        //System.out.println("hello ~");
        log.debug("hello running");
        return "hello";
    }

    @PostMapping("/user")
    @ResponseBody
    public String testDemo02(@RequestBody User user){
        //System.out.println("hello ~");
        log.debug("hello running");
        System.out.println(user.toString());
        return "successs";
    }

    @GetMapping("/getRediectUrl")
    @ResponseBody
    public String testGetRedirectUrl() throws UnsupportedEncodingException {
//        return "http://localhost:8085/test/getRedirect?url=http://baidu.com";
        return "http://localhost:8085/test/getRedirect?url="+URLEncoder.encode("http://baidu.com","utf-8");
    }

    @GetMapping("/getRedirect")
    public String redirect(@RequestParam("url") String url) {
        log.info(url);
        return "redirect:"+url;
    }

}
