package cn.kk.ui;

import cn.kk.dao.IAccountDao;
import cn.kk.service.IAccountService;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Client {
    // 模拟表现层

    public static void main(String[] args) {
        /*
                获取spring的核心容器，并根据id获取对象
         */
        //1. 获取核心容器
        // ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2. 根据id获取bean对象
        IAccountService accountService = (IAccountService)ac.getBean("accountServiceImpl");
        // IAccountService accountService1 = (IAccountService)ac.getBean("accountServiceImpl");
        accountService.saveAccount();
        // System.out.println(accountService);
        // System.out.println(accountService == accountService1);
        ac.close();
    }
}
