package cn.kk.service.impl;

import cn.kk.dao.UserDao;
import cn.kk.pojo.User;
import cn.kk.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserDao userDao;



    @Override
    public void saveUser(User user) throws Exception {
        if (userDao.findByUsername(user.getUsername()) == null) userDao.saveUser(user);
        else throw new RuntimeException("用户名已存在！");
    }

    @Override
    public User login(User user) throws Exception {
        User byUsername = userDao.findByUsername(user.getUsername());
        if (byUsername != null) {
            if (byUsername.getPassword().equals(user.getPassword())) return byUsername;
            else throw new RuntimeException("密码错误!");
        }
        else throw new RuntimeException("用户不存在!");
    }
}
