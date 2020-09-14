package cn.kk.springboot.integration;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("cn.kk.springboot.integration.dao")
@SpringBootApplication
public class IntegrationApplication {

    public static void main(String[] args) {
        SpringApplication.run(IntegrationApplication.class, args);
    }

}
