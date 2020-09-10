package cn.kk.dao;

import cn.kk.domain.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface IPermissionDao {

    /*
        select p.id,p.permissionName,p.url from
		users u INNER JOIN users_role ur ON u.id = ur.userId AND u.id =  '52e2d4f9576c4bea838a54a654d89d84'
		INNER JOIN role r on ur.roleId = r.id
		inner JOIN role_permission rp on r.id = rp.roleId
		inner JOIN permission p on rp.permissionId = p.id;

		以上是数据库的sql语句
     */
    @Select("select * from permission where id in (select permissionId from role_permission where roleId = #{id})")
    List<Permission> findPermissionByRoleIds(String id ) throws Exception;

    @Select("select * from permission")
    List<Permission> findAll() throws Exception;

    @Insert("insert into permission values(#{id},#{permissionName},#{url})")
    void save(Permission permission) throws Exception;

    @Select("select * from permission where id not in (select permissionId from role_permission where roleId = #{roleId} )")
    List<Permission> findNoPermissionByRoleId(String roleId) throws Exception;
}
