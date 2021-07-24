package com.example.redis.demo;

import com.example.redis.demo.po.Student;
import org.springframework.context.annotation.*;

@Configuration
@PropertySources({@PropertySource("classpath:application-dev.properties"),
        @PropertySource("classpath:application-dev-redis.properties"),
        @PropertySource("classpath:application-dev-db.properties")})
@ImportResource({"classpath:dbConfg/dbConfg.xml"})
public class Config {
    @Bean
    public Student getStudent() {
        int s = 2;
        char a = (char) ((int) ('A') + s);
        return Student.builder().name("Auto_student").age(25).build();
    }
}
