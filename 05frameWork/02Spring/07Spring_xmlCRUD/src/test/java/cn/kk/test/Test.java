package cn.kk.test;

import cn.kk.domain.Account;
import cn.kk.service.IAccountService;
import cn.kk.service.impl.AccountServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Test {

    ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
    IAccountService accountService = ac.getBean("accountService", IAccountService.class);

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
}
