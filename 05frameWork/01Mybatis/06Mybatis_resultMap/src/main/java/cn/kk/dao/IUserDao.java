package cn.kk.dao;

import cn.kk.domain.User;

import java.util.List;

public interface IUserDao {

    List<User> findAll();

}
