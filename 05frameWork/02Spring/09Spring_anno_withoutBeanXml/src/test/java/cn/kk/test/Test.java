package cn.kk.test;

import cn.kk.domain.Account;
import cn.kk.service.IAccountService;
import config.SpringConfiguration;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class Test {

    // ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
    // IAccountService accountService = ac.getBean("accountService", IAccountService.class);

    @Autowired
    private IAccountService accountService;

    // @Autowired
    // private ApplicationContext ac;

    @org.junit.Test
    public void testFindAll(){
        List<Account> accounts = accountService.findAll();
        System.out.println(accounts);
    }

    @org.junit.Test
    public void testFindOne() {
        Account one = accountService.findOne(1);
        System.out.println("one = " + one);
    }

    @org.junit.Test
    public void testSaveAccount() {
        Account account = new Account();
        account.setName("kk");
        account.setMoney(1000);
        accountService.saveAccount(account);
    }

    @org.junit.Test
    public void testUpdate() {
        Account account = new Account();
        account.setId(4);
        account.setName("kk");
        account.setMoney(99999);
        accountService.update(account);
    }

    @org.junit.Test
    public void testDelete() {
        accountService.deleteAccount(4);
    }

    /*
            测试单例多例
     */
    // @org.junit.Test
    // public void queryRunnerTest() {
    //     QueryRunner runner1 = ac.getBean("runner", QueryRunner.class);
    //     QueryRunner runner2 = ac.getBean("runner", QueryRunner.class);
    //     System.out.println(runner1 == runner2);
    // }
}
