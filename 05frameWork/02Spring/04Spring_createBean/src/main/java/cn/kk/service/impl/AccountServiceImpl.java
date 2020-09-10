package cn.kk.service.impl;

import cn.kk.service.IAccountService;

public class AccountServiceImpl implements IAccountService {
    public AccountServiceImpl( ){
        System.out.println("对象被创建了");
    }
    public void saveAccount() {
        System.out.println("service里面的saveAccount");
    }
    public void init(){
        System.out.println("初始化");
    }
    public void destroy(){
        System.out.println("销毁");
    }
}
