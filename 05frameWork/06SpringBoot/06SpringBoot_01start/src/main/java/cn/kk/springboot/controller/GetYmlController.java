package cn.kk.springboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GetYmlController {

    //获取配置文件中的name
    @Value("${name}")
    private String name;

    //对象的字段
    @Value("${person.addr}")
    private String addr;

    //list集合
    @Value("${city[2]}")
    private String city;

    //map集合
    @Value("${map.key1}")
    private String key1;

    /*
        获取配置文件信息
     */
    @RequestMapping("/getPara")
    @ResponseBody
    public String quick2(){
        return "name = "+name+"----" +
                "addr = "+addr+"----" +
                "city = "+city+"----" +
                "key1 = "+key1
                ;
    }

}
