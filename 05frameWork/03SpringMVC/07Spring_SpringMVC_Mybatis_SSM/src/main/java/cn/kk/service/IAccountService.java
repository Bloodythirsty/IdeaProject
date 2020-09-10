package cn.kk.service;

import cn.kk.domain.Account;

import java.util.List;

public interface IAccountService {

    public List<Account> findAll();

    public Account findById(Integer id);

    public void saveAccount(Account account);

    public void update(Account account);

    public void transfer(double money);
}
