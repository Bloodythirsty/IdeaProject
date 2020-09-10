package cn.kk.factory;

import cn.kk.service.IAccountService;
import cn.kk.service.impl.AccountServiceImpl;

/*
        模拟一个静态工厂类，静态方法创建对象
 */
public class StaticFactory {

    public static IAccountService getAccountService(){
        return new AccountServiceImpl();
    }
}
