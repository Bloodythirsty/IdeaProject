package cn.kk.ui;

import cn.kk.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
    // 模拟表现层

    public static void main(String[] args) {
        /*
                获取spring的核心容器，并根据id获取对象
         */
        // IAccountService iAccount = new AccountServiceImpl();
        //1. 获取核心容器
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2. 根据id获取bean对象
        IAccountService accountService1 = (IAccountService)ac.getBean("accountService");
        // IAccountService accountService2 = (IAccountService)ac.getBean("accountService");
        // System.out.println(accountService1 == accountService2);

        // 手动关闭容器
        ac.close();

    }
}
