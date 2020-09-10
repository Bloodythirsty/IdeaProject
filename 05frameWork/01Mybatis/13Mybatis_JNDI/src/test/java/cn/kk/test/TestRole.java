package cn.kk.test;

import cn.kk.dao.IRoleDao;
import cn.kk.domain.Role;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

public class TestRole {

    static InputStream in;
    static SqlSessionFactoryBuilder builder;
    static SqlSessionFactory factory;
    static IRoleDao iRoleDao;

    public static void init() throws IOException {
        //1. 读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2. 根据创建者模式创建工厂
        builder = new SqlSessionFactoryBuilder();
        factory = builder.build(in);
        SqlSession sqlSession = factory.openSession();
       // SqlSession sqlSession = factory.openSession(true);    开启自动提交，即关闭事务
        iRoleDao = sqlSession.getMapper(IRoleDao.class);
    }

    static Scanner scanner;
    public static void main(String[] args) throws IOException {


        init();

        scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        //5. 使用代理对象执行方法
        if ("r".equals(s)){
            List<Role> roles = iRoleDao.findAll();
            for (Role r:roles){
                System.out.println("role = " + r);
            }
        }else{

        }

        close();
    }

    public static void close() throws IOException {
        in.close();
        scanner.close();
    }
}
