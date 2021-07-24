package com.example.redis.demo;

import com.example.redis.demo.testAnno.TestConf;
import com.example.redis.demo.testAnno.TestConfT;
import com.example.redis.demo.po.Student;
import com.example.redis.demo.util.RedisUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
    }


    @Resource
    private RedisUtils redisUtils1;

    @Test
    void testSet() {
        boolean b = redisUtils1.set("test1", "test1");
        System.out.println("b = " + b);
    }

    @Test
    void testSetPo(){
        // Student student = Student.builder().name("张康康").age(25).build();
        // redisUtils.setKey("student",student);
        Student student = (Student) redisUtils1.get("student");
        System.out.println("student = " + student);
    }

    @Resource
    private TestConf conf1;

    @Test
    void name() {
        System.out.println("conf = " + conf1.toString());
    }

    @Resource
    private TestConfT conf2;

    @Test
    void test1() {
        System.out.println("redisUtils = " + conf2.toString());
    }

    @Resource
    private Student student;

    @Test
    void testStudent() {
        System.out.println("student = " + student.toString());
    }
}
