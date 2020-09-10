package cn.kk.dao;

import cn.kk.domain.User;

import java.util.List;

public interface IUserDao {

    List<User> findAll();


    User findById(int id);

    // 一对多查询，一个用户对应多个账户
    List<User> findAllUserAccount();

}
