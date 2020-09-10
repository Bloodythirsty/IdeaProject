package cn.kk.test;

import cn.kk.dao.IUserDao;
import cn.kk.domain.QueryVo;
import cn.kk.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class TestDao {

    static InputStream in;
    static SqlSessionFactoryBuilder builder;
    static SqlSessionFactory factory;
    static SqlSession sqlSession;
    static IUserDao userDao;

    public static void init() throws IOException {
        //1. 读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2. 根据创建者模式创建工厂
        builder = new SqlSessionFactoryBuilder();
        factory = builder.build(in);
        //3 根据工厂创建sqlSession
        sqlSession = factory.openSession();
        //4. 用sqlSession创建Dao接口的代理对象
        userDao = sqlSession.getMapper(IUserDao.class);
    }

    public static void main(String[] args) throws IOException {


        init();

        //5. 使用代理对象执行方法
        List<User> users = userDao.findAll();
        for (User u:users){
            System.out.println("user = " + u);
        }

        close();
    }

    public static void close() throws IOException {
        //6. 关闭资源
        //没有提交事务，修改不成功  Setting autocommit to false on JDBC Connection
        sqlSession.commit();    //主动提交  Committing JDBC Connection
        //因为前面没有提交，回滚了一次，id 49被分配了，所以提交后id=50

        sqlSession.close();
        in.close();
    }
}
