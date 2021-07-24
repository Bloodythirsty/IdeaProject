package com.kk.service;

import com.kk.dao.UserDao;
import com.kk.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    @Autowired
    UserDao userDao;

    @Transactional
    public void testTx(){
        User user = new User();
        user.setId(2);
        user.setName("22222");
        userDao.insertUser(user);

        User user1 = new User();
        user1.setId(1);
        user1.setName("11111");
        userDao.insertUser(user1);
    }
}
