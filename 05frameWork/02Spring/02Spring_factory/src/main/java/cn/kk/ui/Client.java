package cn.kk.ui;

import cn.kk.factory.BeanFactory;
import cn.kk.service.IAccountService;

public class Client {
    // 模拟表现层

    public static void main(String[] args) {
        IAccountService iAccount = (IAccountService) BeanFactory.getBean("accountService");
        for (int i = 0; i < 5; i++) {
            iAccount.saveAccount();
            System.out.println(iAccount);
        }
    }
}
