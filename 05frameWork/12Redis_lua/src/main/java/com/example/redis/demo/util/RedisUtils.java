package com.example.redis.demo.util;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Component
public class RedisUtils {

    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    @Resource
    private DefaultRedisScript<Boolean> checkAndSetScript;

    // ==================== common ===================================
    public boolean expire(String key, long time){
        try {
            if(time > 0){
                redisTemplate.expire(key,time, TimeUnit.SECONDS);
            }
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean del(String key){
        try {
            redisTemplate.delete(key);
            return true;
        }catch (Exception e){
            return  false;
        }
    }


    // ==================== String ===================================
    public boolean set(String key,Object value){
        try {
            redisTemplate.opsForValue().set(key,value);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public Object get(String key){
        return StringUtils.isBlank(key) ? null: redisTemplate.opsForValue().get(key);
    }


    // ==================== lua ===================================
    public void checkAndSetScript(String key,String oldValue,String newValue){
        Boolean b = redisTemplate.execute(checkAndSetScript, Lists.newArrayList(key), oldValue, newValue);
        System.out.println("b = " + b);
    }

}
