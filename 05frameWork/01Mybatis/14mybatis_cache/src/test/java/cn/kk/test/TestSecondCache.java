package cn.kk.test;

import cn.kk.dao.IUserDao;
import cn.kk.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

public class TestSecondCache {

    static InputStream in;
    static SqlSessionFactoryBuilder builder;
    static SqlSessionFactory factory;

    public static void init() throws IOException {
        //1. 读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2. 根据创建者模式创建工厂
        builder = new SqlSessionFactoryBuilder();
        factory = builder.build(in);
    }

    public static void main(String[] args) throws IOException {


        init();

        SqlSession sqlSession1 = factory.openSession();
        IUserDao userDao1 = sqlSession1.getMapper(IUserDao.class);
        User u1 = userDao1.findById(52);
        System.out.println("u1 = " + u1);
        sqlSession1.close();                                                //让一级缓存消失

        SqlSession sqlSession2 = factory.openSession();
        IUserDao userDao2 = sqlSession2.getMapper(IUserDao.class);
        User u2 = userDao2.findById(52);
        System.out.println("u2 = " + u2);
        sqlSession2.close();                                                //让一级缓存消失

        System.out.println(u1 == u2);               // false ，因为二级缓存存的时数据（JSON格式），而非对象

        close();
    }

    public static void close() throws IOException {
        in.close();
    }
}
