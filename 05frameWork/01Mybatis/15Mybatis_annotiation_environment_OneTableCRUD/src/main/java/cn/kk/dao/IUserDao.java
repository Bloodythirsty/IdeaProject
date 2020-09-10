package cn.kk.dao;

import cn.kk.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**

 Select
 Insert
 Update
 Delete
 */
public interface IUserDao {

    // 查询所有
    @Select("select * from user")
    List<User> findAll();

    @Insert("insert into user(username,birthday,sex,address) values(#{username},#{birthday},#{sex},#{address})")
    void savaUser(User user);

    @Delete("delete from user where id = #{id}")
    void deleteUser(int id);

    @Update("update user set username = #{username} where id = #{id}")
    void updateUser(User user);

    @Select("select * from user where id = #{id}")
    User findOneById(int id);

    // @Select("select * from user where username like #{username}")
    @Select("select * from user where username like '%${value}%'")
    List<User> findUserByUsernameLike(String username);

    @Select("select count(*) from user")
    int findTotal();
}
