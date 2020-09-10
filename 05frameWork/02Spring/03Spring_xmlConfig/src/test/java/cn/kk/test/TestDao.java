package cn.kk.test;

import cn.kk.dao.IAccountDao;
import cn.kk.service.IAccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDao {

    @Test
    public void test(){
        {

        /*
                获取spring的核心容器，并根据id获取对象
         */
            // IAccountService iAccount = new AccountServiceImpl();
            //1. 获取核心容器
            ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
            //2. 根据id获取bean对象
            IAccountService accountService = (IAccountService)ac.getBean("accountService");
            IAccountDao accountDao = ac.getBean("accountDao", IAccountDao.class);
            for (int i = 0; i < 5; i++) {
                accountService.saveAccount();
                System.out.println(accountService);
                System.out.println(accountDao);
            }
        }
    }
}
