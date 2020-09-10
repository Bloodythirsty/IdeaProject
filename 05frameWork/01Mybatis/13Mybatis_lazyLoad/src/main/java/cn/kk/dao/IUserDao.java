package cn.kk.dao;

import cn.kk.domain.User;

import java.util.List;

public interface IUserDao {


    User findById(int id);

    // 一对多查询，一个用户对应多个账户，延迟加载
    List<User> findAllUserAccount();

}
