package cn.kk.dao;

import cn.kk.domain.Account;
import cn.kk.domain.AccountUser;

import java.util.List;

public interface IAccountDao {

    // 查询所有账户，并且获取当前账户的所有用户信息
    List<Account> findAll();

    // 实现一对多的延迟查询的辅助查询
    List<Account> findAccountByUid(int id);
}
