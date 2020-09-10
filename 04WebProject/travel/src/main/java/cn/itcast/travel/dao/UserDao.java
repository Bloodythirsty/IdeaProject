package cn.itcast.travel.dao;

import cn.itcast.travel.domain.User;

public interface UserDao {

    User queryByUsername(User user);
    boolean addUser(User user);

    User findByCode(String code);

    void updateStatus(User user);
}
