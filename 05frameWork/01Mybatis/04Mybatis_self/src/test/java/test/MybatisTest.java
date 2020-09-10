package test;

import dao.UserDao;
import domain.User;

import mybatis.io.Resources;
import mybatis.session.SqlSession;
import mybatis.session.SqlSessionFactoryBuilder;
import mybatis.session.SqlSessionFactory;

// import org.apache.ibatis.io.Resources;
// import org.apache.ibatis.session.SqlSession;
// import org.apache.ibatis.session.SqlSessionFactory;
// import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {

    public static void main(String[] args) throws IOException {
        //1. 读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2. 创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);          //里面用到XMLConfigBuilder，读取XML文件，获取CFG,获取所有Mappers
        //3. 使用工厂生产SqlSession
        SqlSession sqlSession = factory.openSession();          //得到defaultSqlSession：
        //4. 使用SqlSession创建Dao接口的代理对象
        UserDao userDao = sqlSession.getMapper(UserDao.class);  //利用代理得到UserDao
        //5. 使用代理对象执行方法
        List<User> users = userDao.findAll();                   //执行MapperProxy里面的invoke方法
        for (User u :users){
            System.out.println("u = " + u);
        }
        //6. 释放资源
        sqlSession.close();
        in.close();
    }
}
