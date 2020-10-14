package cn.kk;

import cn.kk.pojo.User;
import cn.kk.utils.redis.RedisUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;
import java.util.concurrent.TimeUnit;

@SpringBootTest
public class testRedis {

    @Autowired
    private RedisUtils utils;

    @Test
    void testRedis() {
        utils.set("jackss2", "jack2");
    }

    @Test
    void testGet() throws JsonProcessingException {
        /*
                取出来是字符串，转对象，不好转
         */
        // Object o = utils.get("3");
        // System.out.println("3 = " + o);
        // System.out.println("o.getClass() = " + o.getClass());
        // ObjectMapper objectMapper = new ObjectMapper();
        // User user = objectMapper.readValue(o.toString(), User.class);
        // System.out.println("user = " + user);

        /*
                是json字符串,取出来是LinkedHashMap
         */
        HashMap o = (LinkedHashMap)utils.get("2");
        System.out.println("2 = " + o);
        System.out.println("o.getClass() = " + o.getClass());

        Set set = o.keySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            Object next = iterator.next();
            System.out.println("next+o.get(next) = " + next + o.get(next));
        }

        /*
                自带的序列化 map->对象
         */
        ObjectMapper objectMapper = new ObjectMapper();
        // User user = objectMapper.convertValue(o,User.class);
        // System.out.println("user = " + user);

        /*
                先转成json，后转对象
         */
        String asString = objectMapper.writeValueAsString(o);
        System.out.println("asString = " + asString);
        User user = objectMapper.readValue(asString, User.class);
        System.out.println("user2 = " + user);

    }

    @Test
    void testRedisList() {
        for (int i = 0; i < 10; i++) {
            utils.lPush("mylist", "str--"+i);
        }
    }

    @Test
    void testRedisListGet() {
        List<Object> mylist = utils.lRange("mylist", 0, -1);
        for (Object o : mylist) {
            System.out.println("(String) o = " + (String) o);
        }
    }

    @Test
    void testOb() {
        User user = new User();
        user.setId(2).setPassword("123").setUsername("kk");
        utils.set("3", user.toString());
    }


    @Test
    void testRedisExpire() {

        utils.set("testExpire", "Expire",10L, TimeUnit.SECONDS);

    }
}
