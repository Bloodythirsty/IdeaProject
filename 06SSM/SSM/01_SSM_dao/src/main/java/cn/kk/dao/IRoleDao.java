package cn.kk.dao;

import cn.kk.domain.Role;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRoleDao {

    /*
            1. 和sql数据库中查询有点不一样，子查询方便封装
            2. 每次查询传递的值可以不一样
                1. User给role传递的是user.id
                2. role给permission传递的是role.id
     */
    @Select("select * from role where id in (select roleId from users_role where userid = #{usersId})")
    @Results(value = {
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "id",column = "id"),
            @Result(property = "roleName",column = "roleName"),
            @Result(property = "roleDesc",column = "roleName"),
            @Result(property = "permissionList",column = "id",javaType = List.class,
                many = @Many(select = "cn.kk.dao.IPermissionDao.findPermissionByRoleIds",fetchType = FetchType.LAZY)
            )
    })
    public List<Role> findRoleListByUsersId(String usersId) throws Exception;

    @Select("select * from role")
    public List<Role> findAll() throws Exception;

    @Insert("insert into role values(#{id},#{roleName},#{roleDesc})")
    public void save(Role role) throws Exception;

    @Select("select * from role where id not in (select roleId from users_role where userid = #{usersId})")
    public List<Role> findRoleListByUsersIdNotRole(String usersId) throws Exception;

    @Select("select * from role where id = #{roleId}")
    @Results(value = {
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "roleName",column = "roleName"),
            @Result(property = "roleDesc",column = "roleName"),
            @Result(property = "permissionList",column = "id",javaType = List.class,
                    many = @Many(select = "cn.kk.dao.IPermissionDao.findPermissionByRoleIds",fetchType = FetchType.LAZY)
            )
    })
    public Role findById(String roleId) throws Exception;

    @Select("select * from role where id = #{roleId}")
    @Results(value = {
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "roleName",column = "roleName"),
            @Result(property = "roleDesc",column = "roleName"),
            @Result(property = "permissionList",column = "id",javaType = List.class,
                    many = @Many(select = "cn.kk.dao.IPermissionDao.findNoPermissionByRoleId",fetchType = FetchType.LAZY)
            )
    })
    public Role findRoleContainNoPermission(String roleId) throws Exception;

    @Insert("insert into role_permission(roleId,permissionId) values(#{roleId},#{permissionId})")
    public void addPermissionToRole(@Param("roleId") String roleId,@Param("permissionId") String permissionId) throws Exception;
}
