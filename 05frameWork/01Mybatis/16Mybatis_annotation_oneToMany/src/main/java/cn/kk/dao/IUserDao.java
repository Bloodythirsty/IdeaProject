package cn.kk.dao;

import cn.kk.domain.User;
import com.sun.xml.internal.bind.v2.model.core.ID;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**

 Select
 Insert
 Update
 Delete
 */
@CacheNamespace(blocking = true)
public interface IUserDao {

    // 查询所有
    @Select("select * from user")
    @Results(id = "userMap",value = {
            @Result(id = true,property = "userId",column = "id"),
            @Result(property = "userUsername",column = "username"),
            @Result(property = "userSex",column = "sex"),
            @Result(property = "userAddress",column = "address"),
            @Result(property = "userBirthday",column = "birthday"),
            @Result(property = "accounts",column = "id",
                many = @Many(select = "cn.kk.dao.IAccountDao.findAccountsByUid",fetchType = FetchType.LAZY) //一对多查询，延迟加载
            )
    })
    List<User> findAll();

    /*
            根据id查询，辅助account的一对一查询
     */
    @Select("select * from user where id = #{id}")
    // @ResultMap(value = {"userMap"})     //标准写法
    @ResultMap("userMap")                   //只有一个元素的写法
    User findOneById(int id);

    @Select("select * from user where username like #{username}")
    @ResultMap("userMap")                   //只有一个元素的写法
    List<User> findUserByUsernameLike(String username);

}
