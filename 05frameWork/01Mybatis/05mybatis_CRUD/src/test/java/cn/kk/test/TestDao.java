package cn.kk.test;

import cn.kk.dao.IUserDao;
import cn.kk.domain.QueryVo;
import cn.kk.domain.User;
import com.sun.xml.internal.bind.util.Which;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

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

    static Scanner scanner;
    @Test
    public void test( ) throws IOException {


        init();

        scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        //5. 使用代理对象执行方法
        if ("r".equals(s)){
            List<User> users = userDao.findAll();
            for (User u:users){
                System.out.println("user = " + u);
            }
        }else if ("c".equals(s)){
            User user = new User();
            user.setUsername("康康 last insertid");
            user.setBirthday(new Date());
            user.setSex("男");
            user.setAddress("南关街");
            System.out.println("userBefore = " + user);
            userDao.saveUser(user);
            System.out.println("userAfter = " + user);
        }else if ("u".equals(s)){
            User user = new User();
            user.setId(50);
            user.setUsername("zhang康康");
            user.setBirthday(new Date());
            user.setSex("男");
            user.setAddress("南关街");
            userDao.updateUser(user);
        }else if ("d".equals(s)){  //删除
            userDao.deleteUser(50);
        }else if ("one".equals(s)){
            User user = userDao.findById(48);
            System.out.println("user = " + user);
        }else if ("by".equals(s)){
            List<User> users = userDao.findNameByLike("小%");
            for (User u:users){
                System.out.println("user = " + u);
            }
        }else if ("oneone".equals(s)){
            int total = userDao.findTotal();
            System.out.println("total = " + total);
        }else if ("ognl".equals(s)){
            QueryVo queryVo = new QueryVo();
            User user = new User();
            user.setUsername("%王%");
            user.setBirthday(new Date());
            user.setSex("女");
            user.setAddress("hahahha");
            queryVo.setUser(user);
            userDao.findUserByVo(queryVo);
        }else{

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
        scanner.close();
    }
}
