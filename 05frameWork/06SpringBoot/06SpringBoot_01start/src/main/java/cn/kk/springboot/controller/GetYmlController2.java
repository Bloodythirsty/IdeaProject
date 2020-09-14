package cn.kk.springboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ConfigurationProperties(prefix = "person")
public class GetYmlController2 {

    //获取配置文件中的name
    private String name;
    private Integer age;
    private String addr;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    /*
            获取配置文件信息
         */
    @RequestMapping("/getPara2")
    @ResponseBody
    public String quick2(){
        return "GetYmlController2{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", addr='" + addr + '\'' +
                '}';
    }

}
