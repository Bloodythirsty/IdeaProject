package cn.kk.service;

import cn.kk.mapper.UserMapper;
import cn.kk.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User findById(int id){
        // try {
        //     Thread.sleep(2000L);
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }
        return userMapper.selectByPrimaryKey(id);
    }
}
