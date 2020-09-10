package cn.kk.dao;

import cn.kk.domain.Users;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface IUserDao {

    @Select("select * from users where username = #{username}")
    @Results(value = {
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "email",column = "email"),
            @Result(property = "username",column = "username"),
            @Result(property = "password",column = "password"),
            @Result(property = "phoneNum",column = "phoneNum"),
            @Result(property = "status",column = "status"),
            @Result(property = "rolesList",column = "id",
            javaType = List.class,many = @Many(select = "cn.kk.dao.IRoleDao.findRoleListByUsersId",fetchType = FetchType.LAZY))
    })
    public Users findByUsername(String username) throws Exception;


    @Select("select * from users")
    public List<Users> findAll() throws Exception;

    @Insert("insert into users values(#{id},#{email},#{username},#{password},#{phoneNum},#{status})")
    public void save(Users users) throws Exception;

    /*
            三表查询
            根据user的id查询角色，再查询角色拥有的权限
     */
    @Select("select * from users where id = #{id}")
    @Results(value = {
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "email",column = "email"),
            @Result(property = "username",column = "username"),
            @Result(property = "password",column = "password"),
            @Result(property = "phoneNum",column = "phoneNum"),
            @Result(property = "status",column = "status"),
            @Result(property = "rolesList",column = "id",
                    javaType = List.class,many = @Many(select = "cn.kk.dao.IRoleDao.findRoleListByUsersId",fetchType = FetchType.LAZY))
    })
    public Users findById(String id) throws Exception;


    /*
            三表查询
            根据user的id查询角色，再查询角色拥有的权限
     */
    @Select("select * from users where id = #{id}")
    @Results(value = {
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "email",column = "email"),
            @Result(property = "username",column = "username"),
            @Result(property = "password",column = "password"),
            @Result(property = "phoneNum",column = "phoneNum"),
            @Result(property = "status",column = "status"),
            @Result(property = "rolesList",column = "id",
                    javaType = List.class,many = @Many(select = "cn.kk.dao.IRoleDao.findRoleListByUsersIdNotRole",fetchType = FetchType.LAZY))
    })
    public Users findByIdAndNotRole(String id) throws Exception;

    /*
            给users_role中添加数据
     */
    @Insert("insert into users_role(userId,roleId) values(#{userId},#{roleId})")
    public void addRoleToUser(@Param("userId") String userId,@Param("roleId") String roleId) throws Exception;
}
