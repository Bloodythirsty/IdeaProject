package cn.itcast.test;

import cn.itcast.dao.UserDao;
import cn.itcast.dao.impl.UserDaoImpl;
import cn.itcast.domain.User;
import org.junit.Test;

import java.util.List;

public class TestDao {

    @Test
    public void test(){
        UserDao dao = new UserDaoImpl();
        List<User> all = dao.findAll();
        for(User u:all){
            System.out.println(u);
        }

        User zhangsan = dao.findUserByUsernameAndPassword("zhangsan", "123");
        System.out.println("zhangsan = " + zhangsan);

        User zhan = dao.findUserByUsernameAndPassword("zhan", "123");
        System.out.println("zhan = " + zhan);
    }

}
