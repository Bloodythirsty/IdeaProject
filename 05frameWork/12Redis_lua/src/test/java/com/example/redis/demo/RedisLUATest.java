package com.example.redis.demo;

import com.example.redis.demo.util.RedisUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class RedisLUATest {

    @Resource
    private RedisUtils redisUtils;

    @Test
    void testheck() {
        String key = "test_check_and _set";
        String oldValue = "oldValue";
        String newValue = "newValue";
        redisUtils.set(key,oldValue);
        redisUtils.checkAndSetScript(key,oldValue,newValue);
    }
}
