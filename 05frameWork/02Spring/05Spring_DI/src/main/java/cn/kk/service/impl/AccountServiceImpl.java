package cn.kk.service.impl;

import cn.kk.service.IAccountService;

import java.util.Date;

public class AccountServiceImpl implements IAccountService {

    // 如果时经常变化的属性，并不适用于注入的方式
    private String name;
    private Integer age;
    private Date bir;

    public AccountServiceImpl(String name, Integer age, Date bir) {
        this.name = name;
        this.age = age;
        this.bir = bir;
    }

    public void saveAccount() {
        System.out.println("service里面的saveAccount"+name+","+age+bir);
    }
}
