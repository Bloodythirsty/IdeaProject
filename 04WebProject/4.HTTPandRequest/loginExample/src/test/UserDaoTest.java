package test;

import dao.UserDao;
import kk.User;
import org.junit.Test;

/**
 * @author zkk;
 * @create 2020-03-25;
 */
public class UserDaoTest {


    @Test
    public void testLogin(){
        User loginUser = new User();
        loginUser.setUsername("zhang");
        loginUser.setPassword("kang1");

        UserDao userDao = new UserDao();
        User user = userDao.login(loginUser);
        System.out.println("user = " + user);
    }

}
