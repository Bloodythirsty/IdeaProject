package cn.kk.springboot.integration;

import cn.kk.springboot.integration.dao.UserMapper;
import cn.kk.springboot.integration.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class IntegrationApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void testMapper() {
        List<User> users = userMapper.queryUserList();
        for (User user : users) {
            System.out.println("user = " + user);
        }
    }

}
