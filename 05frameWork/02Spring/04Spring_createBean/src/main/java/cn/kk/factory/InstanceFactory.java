package cn.kk.factory;

import cn.kk.service.IAccountService;
import cn.kk.service.impl.AccountServiceImpl;

/*
        模拟一个工厂类，存在于jar包，无法修改源码提供默认构造函数
 */
public class InstanceFactory {

    public IAccountService getAccountService(){
        return new AccountServiceImpl();
    }
}
