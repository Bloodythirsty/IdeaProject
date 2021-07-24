package cn.kk.dao;

import cn.kk.domain.QueryVo;
import cn.kk.domain.User;

import java.util.List;

public interface IUserDao111 {

    List<User> findAll();

    void saveUser(User user);

    void updateUser(User user);

    void deleteUser(int id);

    User findById(int id);

    List<User> findNameByLike(String s);

    int findTotal();

    // 根据QueryVo查询用户
    List<User> findUserByVo(QueryVo vo);
}
