package com.example.redis.demo.testAnno;

import com.example.redis.demo.po.Student;
import lombok.ToString;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component("conf2")
@ToString
public class TestConfT {

    private String hostT;
    private int portT;

    @Resource
    public void testEnableCP(Student student) {
        this.hostT = student.getName();
        this.portT = student.getAge();
    }
}
