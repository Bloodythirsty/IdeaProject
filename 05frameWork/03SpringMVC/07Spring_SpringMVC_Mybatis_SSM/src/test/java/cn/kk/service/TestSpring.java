package cn.kk.service;

import cn.kk.dao.IAccountDao;
import cn.kk.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:SpringConfig.xml")
public class TestSpring {

    @Resource(name = "accountService")
    private IAccountService accountService;

    @Resource(name = "accountDao")
    private IAccountDao accountDao;

    @Test
    public void testService() {
        accountService.findAll();
    }

    @Test
    public void testDaoFind() throws IOException {


        InputStream in = Resources.getResourceAsStream("js/SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = factory.openSession();
        accountDao = sqlSession.getMapper(IAccountDao.class);

        List<Account> accounts = accountDao.findAll();
        for (Account account : accounts) {
            System.out.println("account = " + account);
        }

        in.close();
        sqlSession.close();
    }

    @Test
    public void testDaoSave() throws IOException {
        InputStream in = Resources.getResourceAsStream("js/SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = factory.openSession();
        accountDao = sqlSession.getMapper(IAccountDao.class);

        Account account = new Account();
        account.setName("kk333");
        account.setMoney(1000000d);

        accountDao.saveAccount(account);

        sqlSession.commit();
        in.close();
        sqlSession.close();
    }

    @Test
    public void testDao() {
        List<Account> all = accountDao.findAll();
        for (Account account : all) {
            System.out.println("account = " + account);
        }
    }

    @Test
    public void testSSM() {
        List<Account> all = accountService.findAll();
        for (Account account : all) {
            System.out.println("account = " + account);
        }
    }

    @Test
    public void testTx() {
        accountService.transfer(500d);
    }
}
