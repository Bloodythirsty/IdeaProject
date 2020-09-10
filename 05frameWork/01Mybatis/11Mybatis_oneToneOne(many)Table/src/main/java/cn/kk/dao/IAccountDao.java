package cn.kk.dao;

import cn.kk.domain.Account;
import cn.kk.domain.AccountUser;
import cn.kk.domain.User;

import java.util.List;

public interface IAccountDao {

    // 查询所有账户，并且获取当前账户的所有用户信息
    List<Account> findAll();

    //查询所有账户，并且带有用户名和地址信息
    List<AccountUser> findAllAccountUser();
}
