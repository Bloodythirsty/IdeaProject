package cn.kk.dao;

import cn.kk.domain.User;

import java.util.List;

public interface IUserDao {

    List<User> findAll();

    void saveUser(User user);

    void updateUser(User user);

    void deleteUser(int id);

    User findById(int id);

    List<User> findNameByLike(String s);

    int findTotal();

}
