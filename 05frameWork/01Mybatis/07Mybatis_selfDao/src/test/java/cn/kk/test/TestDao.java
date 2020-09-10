package cn.kk.test;

import cn.kk.dao.IUserDao;
import cn.kk.dao.impl.UserDaoImpl;
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
    static IUserDao userDao;

    public static void init() throws IOException {
        //1. 读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2. 根据创建者模式创建工厂
        builder = new SqlSessionFactoryBuilder();
        factory = builder.build(in);
        //3 根据自己写的实现类，工厂创建sqlSession
        userDao = new UserDaoImpl(factory);
    }

    static Scanner scanner;
    public static void main(String[] args) throws IOException {


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
            user.setId(51);
            user.setUsername("zhang康康");
            user.setBirthday(new Date());
            user.setSex("男");
            user.setAddress("南关街");
            userDao.updateUser(user);
        }else if ("d".equals(s)){  //删除
            userDao.deleteUser(53);
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
        }else{

        }

        close();
    }

    public static void close() throws IOException {
        in.close();
        scanner.close();
    }
}
