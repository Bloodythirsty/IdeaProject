package cn.kk.controller;

import cn.kk.pojo.User;
import cn.kk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService service;

    @RequestMapping("/findById/{id}")
    public User findById(@PathVariable(name = "id")int id){
        return service.findById(id);
    }

}
