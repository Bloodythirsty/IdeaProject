package cn.kk.springboot.integration.domain;


import com.alibaba.fastjson.JSON;

public class TestJson {
    public static void main(String[] args) {
        User user = new User();
        user.setId(1L);
        user.setName("康");
        user.setPassword("123");
        user.setUsername("浪");
        user.setTEST("test");

        String s = JSON.toJSONString(user);
        System.out.println("s = " + s);

        User user1 = JSON.parseObject(s, User.class);
        System.out.println("user1 = " + user1);


    }
}
