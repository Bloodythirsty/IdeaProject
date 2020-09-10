package test;

import bean.User;
import dao.UserDao;
import org.junit.Test;

/**
 * @author zkk;
 * @create 2020-03-31;
 */
public class UserDaoTest {

    @Test
    public void testLogin(){
        User loginUser = new User();
        loginUser.setUsername("xin");
        loginUser.setPassword("qing");

        UserDao userDao = new UserDao();
        User user = userDao.login(loginUser);
        System.out.println("user = " + user);

    }

}
