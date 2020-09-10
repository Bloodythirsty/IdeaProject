package cn.kk.service.impl;

import cn.kk.service.IAccountService;

public class AccountServiceImpl implements IAccountService {

    public void saveAccount() {
        System.out.println("保存");
    }

    public void updateAccount(int i) {
        System.out.println("更新");
    }

    public int deleteAccount() {
        System.out.println("删除");
        return 0;
    }
}
