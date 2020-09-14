package cn.kk.springboot.integration_hibernate;

import cn.kk.springboot.integration_hibernate.dao.IUserDao;
import cn.kk.springboot.integration_hibernate.domian.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;

@SpringBootTest
public class RedisTest {

    /*
            多有对象转成json字符串存入redis
     */
    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Autowired
    private IUserDao userDao;

    @Test
    void testRedis() throws JsonProcessingException {
        //1. 从redis获取数据，json格式字符串
        BoundValueOperations<String, String> boundValueOperations = redisTemplate.boundValueOps("user.findAll");
        String users = boundValueOperations.get();
        //2. 判断redis中存不存在
        List<User> userList = null;
        if (users == null) {
            //3. 不存在，查询数据库
            userList = userDao.findAll();
            //3.1 转换字符串
            ObjectMapper objectMapper = new ObjectMapper();
            String userListData = objectMapper.writeValueAsString(userList);
            //3.2 存入redis
            boundValueOperations.set(userListData);
            System.out.println("----------------从数据库中获取-----------");
        }else {
            System.out.println("----------------从redis中获取-----------");
            System.out.println("users = " + users);
        }

        //4. 存在，打印
    }
}
