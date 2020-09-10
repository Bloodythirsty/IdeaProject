package cn.kk.service.impl;

import cn.kk.dao.IAccountDao;
import cn.kk.domain.Account;
import cn.kk.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements IAccountService {

    @Resource(name = "accountDao")
    private IAccountDao accountDao;

    @Override
    public List<Account> findAll() {
        System.out.println("findAll_service");
        return accountDao.findAll();
    }

    @Override
    public Account findById(Integer id) {
        System.out.println("findById_service");
        return accountDao.findById(id);
    }

    @Override
    public void saveAccount(Account account) {
        System.out.println("save_service");
        accountDao.saveAccount(account);
    }

    @Override
    public void update(Account account) {
        accountDao.update(account);
    }

    @Override
    public void transfer(double money) {
        Account account1 = accountDao.findById(1);
        Account account2 = accountDao.findById(2);

        account1.setMoney(account1.getMoney() - money);
        account2.setMoney(account2.getMoney() + money);

        accountDao.update(account1);

        int i = 1/0;

        accountDao.update(account2);
    }
}
