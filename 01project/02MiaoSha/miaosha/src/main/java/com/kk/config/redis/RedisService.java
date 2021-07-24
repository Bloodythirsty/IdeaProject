package com.kk.config.redis;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Service
// @EnableConfigurationProperties(RedisConfig.class)
public class RedisService {

    @Autowired
    RedisConfig config;

    @Bean
    public JedisPool jedisPoolFactory(){
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(config.getPoolMaxTotal());
        jedisPoolConfig.setMaxIdle(config.getPoolMaxIdle());
        jedisPoolConfig.setMaxWaitMillis(config.getPoolMaxWait());

        return new JedisPool(jedisPoolConfig, config.getHost(), config.getPort(), config.getTimeout(),
                config.getPassword(), 0);

    }

    private void returnToPool(Jedis jedis) {
        if (jedis!=null) jedis.close();
    }

    @Autowired
    JedisPool jedisPool;

    public <T> T get(String key,Class<T> tClass){
        Jedis jedis = null;
        try{
            jedis=jedisPool.getResource();
            String value = jedis.get(key);
            return StringToObject(value, tClass);
        }finally {
            returnToPool(jedis);
        }


    }

    private <T>T StringToObject(String value,Class<T> tClass) {
        return null;
    }

    public <T> boolean  set(String key,T value){
        Jedis jedis = null;
        try{
            jedis=jedisPool.getResource();
            String s = objectToString(value);
            if (s==null) return false;
            jedis.set(key,s );
            return true;
        }finally {
            returnToPool(jedis);
        }
    }

    /*
            对象转String，需要注意基本类型
     */
    private <T>  String objectToString(T value) {
        if (value==null) return null;
        Class<?> clazz = value.getClass();
        if (clazz == String.class){
            return (String)value;
        }else if (clazz == int.class || clazz == Integer.class || clazz == long.class || clazz == Long.class){
            return ""+value;
        }
        return JSON.toJSONString(value);
    }

}
