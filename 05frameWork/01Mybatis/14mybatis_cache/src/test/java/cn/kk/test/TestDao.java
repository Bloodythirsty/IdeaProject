package cn.kk.test;

import cn.kk.dao.IUserDao;
import cn.kk.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import sun.text.normalizer.UTF16;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

public class TestDao {

    static InputStream in;
    static SqlSessionFactoryBuilder builder;
    static SqlSessionFactory factory;
    static IUserDao userDao;
    static SqlSession sqlSession;

    public static void init() throws IOException {
        //1. 读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2. 根据创建者模式创建工厂
        builder = new SqlSessionFactoryBuilder();
        factory = builder.build(in);
        sqlSession = factory.openSession();
       // SqlSession sqlSession = factory.openSession(true);    开启自动提交，即关闭事务
        userDao = sqlSession.getMapper(IUserDao.class);
    }

    static Scanner scanner;
    public static void main(String[] args) throws IOException {


        init();

        scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        //5. 使用代理对象执行方法
        if ("fusa".equals(s)){
            List<User> users = userDao.findAllUserAccount();
            // for (User u:users){
            //     System.out.println("user = " + u);
            // }
        }else if ("testcache".equals(s)){                                      //测试一级缓存
            User u1 = userDao.findById(42);
            System.out.println("u1 = " + u1);

            // 方法一：清楚缓存，关闭sqlSession
            // sqlSession.close();                             //sqlSession没关闭，则u1=u2
            // sqlSession = factory.openSession();
            // userDao = sqlSession.getMapper(IUserDao.class);

            // 方法二：清楚缓存
            sqlSession.clearCache();

            User u2 = userDao.findById(42);
            System.out.println("u1 = " + u2);

            System.out.println(u1 == u2);
        }else if ("update".equals(s)){                       //测试跟新时缓存的结果

            User u1 = userDao.findById(52);
            System.out.println("u1 = " + u1);

            //更新
            u1.setUsername("TestCache");
            userDao.updateUser(u1);

            //再次查询
            User u2 = userDao.findById(52);
            System.out.println("u = " + u2);

            System.out.println(u1 == u2);
        }

        close();
    }

    public static void close() throws IOException {
        in.close();
        scanner.close();
    }
}
