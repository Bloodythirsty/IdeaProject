package cn.kk.service.impl;

import cn.kk.dao.IAccountDao;
import cn.kk.factory.BeanFactory;
import cn.kk.service.IAccountService;

public class AccountServiceImpl implements IAccountService {

    // private IAccountDao iAccountDao = new AccountDaoImpl();
    private IAccountDao iAccountDao = (IAccountDao) BeanFactory.getBean("accountDao");

    public void saveAccount() {
        iAccountDao.saveAccount();
    }
}
