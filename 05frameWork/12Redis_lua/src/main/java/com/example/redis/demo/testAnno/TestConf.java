package com.example.redis.demo.testAnno;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Data
@ConfigurationProperties(prefix = "spring.redis")
@Configuration
@Component("conf1")
public class TestConf {
    private String host;
    private int port;
    private int timeout;
    private String password;
    private int maxActive;
    private int maxWait;
    private int maxIdle;
    private int minIdle;
}
