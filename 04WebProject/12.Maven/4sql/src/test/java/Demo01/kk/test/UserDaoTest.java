package Demo01.kk.test;

import Demo01.kk.dao.UserDao;
import Demo01.kk.dao.imp.UserDaoImp;
import Demo01.kk.domain.User;
import org.junit.Test;

import java.util.List;

public class UserDaoTest {
    @Test
    public void findAll() throws Exception {
        UserDao userDao = new UserDaoImp();
        List<User> all = userDao.findAll();
        System.out.println("all = " + all);
    }
}
