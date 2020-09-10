package cn.kk.test;

import cn.kk.dao.IAccountDao;
import cn.kk.domain.Account;
import cn.kk.domain.AccountUser;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

public class TestAccountDao {

    static SqlSessionFactoryBuilder builder;
    static InputStream in;
    static IAccountDao iAccountDao;
    static SqlSession sqlSession;


    public static void init() throws IOException {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        builder = new SqlSessionFactoryBuilder();
        sqlSession = builder.build(in).openSession();
        iAccountDao = sqlSession.getMapper(IAccountDao.class);
    }

    static Scanner scanner;

    public static void main(String[] args) throws IOException {
        init();

        scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        if ("ra".equals(s)){
            List<Account> accounts = iAccountDao.findAll();
            for (Account account:accounts){
                System.out.println("-----------------------------");
                System.out.println("account = " + account);
            }
        }else if("rau".equals(s)){
            List<AccountUser> accounts = iAccountDao.findAllAccountUser();
            for (Account account:accounts){
                System.out.println("account = " + account);
            }
        }

    }

    public static void close() throws IOException {
        sqlSession.commit();
        sqlSession.close();
        in.close();
    }
}
