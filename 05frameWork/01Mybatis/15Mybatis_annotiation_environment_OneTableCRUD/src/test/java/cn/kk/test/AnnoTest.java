package cn.kk.test;

import cn.kk.dao.IUserDao;
import cn.kk.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class AnnoTest {

    private static SqlSession sqlSession;
    private static IUserDao userDao;
    private static InputStream in;

    public static void init() {
        //1. 读取配置文件
        try {
            in = Resources.getResourceAsStream("SqlMapConfig.xml");
            sqlSession = new SqlSessionFactoryBuilder().build(in).openSession();
            userDao = sqlSession.getMapper(IUserDao.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        init();

        /*
                查
         */
        // List<User> users = userDao.findAll();
        // for(User user:users){
        //     System.out.println("user = " + user);
        // }


        /*
                增
         */
        // User user = new User();
        // user.setUsername("测试annoation111");
        // user.setSex("男");
        // user.setBirthday(new Date());
        // userDao.savaUser(user);

        /*
                删
         */
        // userDao.deleteUser(61);


        /*
                改
         */
        // User user = new User();
        // user.setId(59);
        // user.setUsername("测试annoation111");
        // userDao.updateUser(user);

        /*
                根据id查
         */
        // User user = userDao.findOneById(51);
        // System.out.println("user = " + user);

        /*
                根据用户名称模糊查询
         */
        // List<User> users = userDao.findUserByUsernameLike("%王%");
        // List<User> users = userDao.findUserByUsernameLike("王");
        // for(User user:users){
        //     System.out.println("user = " + user);
        // }

        /*
                查询总条数
         */
        int total = userDao.findTotal();
        System.out.println("total = " + total);


        close();
    }

    private static void close() {
        sqlSession.commit();
        if (in != null){
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (sqlSession != null) {
            sqlSession.close();
        }
    }
}
