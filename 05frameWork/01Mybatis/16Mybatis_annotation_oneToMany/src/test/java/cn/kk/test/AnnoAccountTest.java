package cn.kk.test;

import cn.kk.dao.IAccountDao;
import cn.kk.dao.IUserDao;
import cn.kk.domain.Account;
import cn.kk.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class AnnoAccountTest {

    private static SqlSession sqlSession;
    private static IAccountDao iAccountDao;
    private static InputStream in;

    public static void init() {
        //1. 读取配置文件
        try {
            in = Resources.getResourceAsStream("SqlMapConfig.xml");
            sqlSession = new SqlSessionFactoryBuilder().build(in).openSession();
            iAccountDao = sqlSession.getMapper(IAccountDao.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        init();

        /*
                查
         */
        List<Account> accounts = iAccountDao.findAll();
        for(Account account:accounts){
            System.out.println("------------------");
            System.out.println("account = " + account);
            System.out.println(account.getUser());
        }


        close();
    }

    private static void close() {
        sqlSession.commit();
        if (in != null){
            try {
                in.close();
                sqlSession.clearCache();
                sqlSession.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (sqlSession != null) {
            sqlSession.close();
        }
    }
}
