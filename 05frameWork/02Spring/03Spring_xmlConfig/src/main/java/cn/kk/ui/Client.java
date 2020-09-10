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
        // IAccountService iAccount = new AccountServiceImpl();
        //1. 获取核心容器
        // ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        // ApplicationContext ac = new FileSystemXmlApplicationContext("D:\\All_Study\\Java\\All_projects\\IdeaProjects\\05frameWork\\02Spring\\03Spring_xmlConfig\\src\\main\\resources\\bean.xml");
        //2. 根据id获取bean对象
        // IAccountService accountService = (IAccountService)ac.getBean("accountService");
        // IAccountDao accountDao = ac.getBean("accountDao", IAccountDao.class);
        // for (int i = 0; i < 5; i++) {
        //     accountService.saveAccount();
        //     System.out.println(accountService);
        //     System.out.println(accountDao);
        // }

        //-----------测试BeanFactory的延迟加载---------------------
        Resource resource = new ClassPathResource("bean.xml");
        XmlBeanFactory factory = new XmlBeanFactory(resource);
        IAccountService accountService = factory.getBean("accountService", IAccountService.class);
        System.out.println("accountService = " + accountService);

    }
}
