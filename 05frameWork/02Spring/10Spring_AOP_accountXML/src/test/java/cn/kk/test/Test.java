package cn.kk.test;

import cn.kk.domain.Account;
import cn.kk.service.IAccountService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class Test {

    @Autowired
    @Qualifier("proxyAccountService")
    IAccountService accountService ;


    @org.junit.Test
    public void testTransfer() {
        accountService.transfer("aaa","bbb",500f);
    }

    @org.junit.Test
    public void testSave() {
        Account account = new Account();
        account.setMoney(99999);
        account.setName("lksdokd");
        accountService.saveAccount(account);
    }
}
