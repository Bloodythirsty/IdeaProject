package cn.itcast.travel.dao;

import cn.itcast.travel.dao.impl.UserDaoImpl;
import cn.itcast.travel.domain.User;
import org.junit.Test;

public class DaoTest {
    @Test
    public void testQueryByUsername(){
        UserDao userDao = new UserDaoImpl();
        User user = new User();
        user.setUsername("zkk");
        User user1 = userDao.queryByUsername(user);
        System.out.println("user1 = " + user1);

    }

}
