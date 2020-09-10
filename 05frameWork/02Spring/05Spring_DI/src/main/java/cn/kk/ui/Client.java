package cn.kk.ui;

import cn.kk.service.IAccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
    // 模拟表现层

    public static void main(String[] args) {

        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2. 根据id获取bean对象
        IAccountService accountService1 = (IAccountService)ac.getBean("accountService");
        accountService1.saveAccount();

    }

    @Test
    public void testSet(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService accountService2 = ac.getBean("accountService2", IAccountService.class);
        accountService2.saveAccount();
    }

    @Test
    public void testArray(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService accountService3 = ac.getBean("accountService3", IAccountService.class);
        accountService3.saveAccount();
    }
}
