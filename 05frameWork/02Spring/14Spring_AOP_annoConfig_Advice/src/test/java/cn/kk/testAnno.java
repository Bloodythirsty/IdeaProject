package cn.kk;

import cn.kk.config.SpringConfig;
import cn.kk.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class testAnno {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfig.class);
        IAccountService accountService = ac.getBean("accountService", IAccountService.class);
        accountService.saveAccount();
    }
}
