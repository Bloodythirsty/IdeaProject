package com.kk.dao;

import com.kk.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserDao {

    @Select("select * from user where id = #{id}")
    public User findById(@Param("id") Integer id);

    @Insert("insert into user values(#{id},#{name})")
    public int insertUser(User user);
}
