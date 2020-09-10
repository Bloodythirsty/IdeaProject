package cn.kk.service.impl;

import cn.kk.service.IAccountService;
import org.springframework.stereotype.Service;

@Service("accountService")
public class AccountServiceImpl implements IAccountService {

    public void saveAccount() {
        System.out.println("保存");
        // int i = 1/0;
    }

    public void updateAccount(int i) {
        System.out.println("更新");
    }

    public int deleteAccount() {
        System.out.println("删除");
        return 0;
    }
}
