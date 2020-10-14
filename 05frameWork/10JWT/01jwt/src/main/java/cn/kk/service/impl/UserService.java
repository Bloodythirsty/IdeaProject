package cn.kk.service.impl;

import cn.kk.dao.UserDao;
import cn.kk.poji.User;
import cn.kk.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    UserDao userDao;

    @Override
    public User findByUsername(String username) {
        User byUsername = userDao.findByUsername(username);
        if (byUsername!=null){
            return byUsername;
        }
        throw new RuntimeException("不存在~");
    }
}
