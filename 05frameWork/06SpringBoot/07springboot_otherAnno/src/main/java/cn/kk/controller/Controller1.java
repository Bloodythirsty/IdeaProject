package cn.kk.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class Controller1 {

    @RequestMapping("/demo01")
    public String testDemo01(){
        //System.out.println("hello ~");
        log.debug("hello running");
        return "hello";
    }

}
