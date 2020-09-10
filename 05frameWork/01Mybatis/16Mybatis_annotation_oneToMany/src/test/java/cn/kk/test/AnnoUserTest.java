package cn.kk.test;

import cn.kk.dao.IUserDao;
import cn.kk.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class AnnoUserTest {

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
                查询用户，并查出相关账户（一对多）
         */
        List<User> users = userDao.findAll();
        for (User user:users){
            System.out.println("user = " + user);
            System.out.println(user.getAccounts());
        }


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
