package cn.kk.dao;

import cn.kk.domain.Account;

public interface IAccountDao {
    Account findById(Integer id);

    Account findByName(String name);

    void updateAccount(Account account);
}
