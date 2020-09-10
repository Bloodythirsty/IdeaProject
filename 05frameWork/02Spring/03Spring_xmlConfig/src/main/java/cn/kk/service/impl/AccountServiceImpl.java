package cn.kk.service.impl;

import cn.kk.dao.IAccountDao;
import cn.kk.dao.impl.AccountDaoImpl;
import cn.kk.service.IAccountService;

public class AccountServiceImpl implements IAccountService {

    private IAccountDao iAccountDao = new AccountDaoImpl();

    public AccountServiceImpl( ){
        System.out.println("对象被创建了");
    }

    public void saveAccount() {
        iAccountDao.saveAccount();
    }
}
