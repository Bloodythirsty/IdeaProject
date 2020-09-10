package cn.kk.dao;

import cn.kk.domain.QueryVo;
import cn.kk.domain.User;

import java.util.List;

public interface IUserDao {

    List<User> findAll();


    User findById(int id);

    List<User> findNameByLike(String s);

    int findTotal();

    //根据传入的参数查找
    List<User> findUserByCondition(User user);

    //根据多个id查询，子查询， select* from user in(41,42,43);
    List<User> findIn(QueryVo queryVo);
}
