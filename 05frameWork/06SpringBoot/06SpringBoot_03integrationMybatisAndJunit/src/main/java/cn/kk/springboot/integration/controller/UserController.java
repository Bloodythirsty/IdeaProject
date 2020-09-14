package cn.kk.springboot.integration.controller;

import cn.kk.springboot.integration.dao.UserMapper;
import cn.kk.springboot.integration.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping(path = "/query")
    public List<User> query(){
        List<User> users = userMapper.queryUserList();
        return users;
    }


}
