package cn.kk.dao;

import cn.kk.domain.Account;

import java.util.List;

public interface IAccountDao {
    List<Account> findAll();

    Account findOne(Integer id);

    void saveAccount(Account account);

    void deleteAccount(Integer id);

    void update(Account account);

    /*
            有唯一结果返回，无结果返回null
            多个结果，抛异常
     */
    Account findByName(String name);
}
