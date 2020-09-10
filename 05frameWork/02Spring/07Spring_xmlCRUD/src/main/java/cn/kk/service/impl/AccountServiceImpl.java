package cn.kk.service.impl;

import cn.kk.dao.IAccountDao;
import cn.kk.domain.Account;
import cn.kk.service.IAccountService;

import java.util.List;

public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao;

    //Spring帮助注入
    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public List<Account> findAll() {
        return accountDao.findAll();
    }

    public Account findOne(Integer id) {
        return accountDao.findOne(id);
    }

    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
    }

    public void deleteAccount(Integer id) {
        accountDao.deleteAccount(id);
    }

    public void update(Account account) {
        accountDao.update(account);
    }
}
