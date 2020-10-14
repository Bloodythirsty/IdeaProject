package cn.kk;

import cn.kk.mapper.UserMapper;
import cn.kk.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void testMapper() {
        User user = userMapper.selectByPrimaryKey(1);
        System.out.println("user = " + user);
    }

}
