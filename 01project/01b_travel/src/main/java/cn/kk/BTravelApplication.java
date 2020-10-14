package cn.kk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@SpringBootApplication
@MapperScan(basePackages = "cn.kk.dao")
public class BTravelApplication {

    public static void main(String[] args) {
        SpringApplication.run(BTravelApplication.class, args);
    }


}
