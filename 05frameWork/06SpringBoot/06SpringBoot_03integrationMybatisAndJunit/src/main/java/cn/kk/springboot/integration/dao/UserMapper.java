package cn.kk.springboot.integration.dao;

import cn.kk.springboot.integration.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from user")
    public List<User> queryUserList();
}
