package cn.kk.service.impl;

import cn.kk.dao.IAccountDao;
import cn.kk.domain.Account;
import cn.kk.service.IAccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements IAccountService {

    @Resource(name = "accountDao")
    private IAccountDao accountDao;

    //使用注解，set不是必须的
    // //Spring帮助注入
    // public void setAccountDao(IAccountDao accountDao) {
    //     this.accountDao = accountDao;
    // }

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
