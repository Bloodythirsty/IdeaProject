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

public class SecondCacheConfigTest {

    private static SqlSession sqlSession;
    private static IUserDao userDao;
    private static InputStream in;
    private static SqlSessionFactoryBuilder builder;
    private static SqlSessionFactory factory;

    public static void init() {
        //1. 读取配置文件
        try {
            in = Resources.getResourceAsStream("SqlMapConfig.xml");
            builder = new SqlSessionFactoryBuilder();
            factory = builder.build(in);
            sqlSession = factory.openSession();
            userDao = sqlSession.getMapper(IUserDao.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        init();


        /*
                一级缓存：它是指mybatis中的sqlSession对象的缓存
                二级缓存：指的是mybatis中sqlSessionFactory对象的缓存
         */

        /*
                根据id查
         */
        User user = userDao.findOneById(51);
        System.out.println("user = " + user);
        sqlSession.close();                         //释放一级缓存

        SqlSession sqlSession1 = factory.openSession();
        IUserDao userDao1 = sqlSession1.getMapper(IUserDao.class);
        User user1 = userDao1.findOneById(51);
        System.out.println("user1 = " + user1);
        sqlSession1.close();

        System.out.println(user == user1);




        close();
    }

    private static void close() {
        if (in != null){
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
