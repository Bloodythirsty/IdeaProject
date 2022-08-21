package pack.controller;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pack.listen.IndustryInfoListener;

/**
 * Description:
 *
 * @Author: heisenzhang@tencent.com
 * @DateTime: 2022-04-24 3:20 PM
 */
@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private IndustryInfoListener listener;

    @GetMapping("/refresh")
    public void refresh(){
        listener.init();
    }

    public static void main(String[] args) {
        ArrayList<String> strings = Lists.newArrayList("1", "2", "3");
        List<String> strings1 = strings.subList(1, strings.size());
        System.out.println("strings1 = " + strings1);

    }
}
