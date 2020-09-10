package cn.kk.dao;

import cn.kk.domain.Account;

import java.util.List;

public interface IAccountDao {
    List<Account> findAll();

    Account findOne(Integer id);

    void saveAccount(Account account);

    void deleteAccount(Integer id);

    void update(Account account);

}
