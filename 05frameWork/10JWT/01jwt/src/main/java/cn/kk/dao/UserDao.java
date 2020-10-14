package cn.kk.dao;


import cn.kk.poji.User;
import org.apache.ibatis.annotations.Select;

public interface UserDao {
    @Select("select * from user where username = #{username}")
    User findByUsername(String username);
}
