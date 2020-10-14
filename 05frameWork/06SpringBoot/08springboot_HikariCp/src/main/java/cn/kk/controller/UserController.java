package cn.kk.controller;

import cn.kk.mapper.UserMapper;
import cn.kk.pojo.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ibatis.annotations.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserMapper userMapper;

    @RequestMapping("/user/{id}")
    public User find(@PathVariable(name = "id") int id) throws JsonProcessingException {
        User user = userMapper.selectByPrimaryKey(id);
        System.out.println("user = " + user);
        // ObjectMapper objectMapper = new ObjectMapper();
        // return objectMapper.writeValueAsString(user);
        return user;
    }
}
