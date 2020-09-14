package cn.kk.springboot.integration_hibernate;

import cn.kk.springboot.integration_hibernate.dao.IUserDao;
import cn.kk.springboot.integration_hibernate.domian.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TestHibernate {

    @Autowired
    private IUserDao userDao;

    @Test
    void testHibernate() {
        List<User> all = userDao.findAll();
        for (User user : all) {
            System.out.println("user = " + user);
        }
    }
}
