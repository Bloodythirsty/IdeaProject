package cn.kk.dao;

import cn.kk.domain.Role;

import java.util.List;

public interface IRoleDao {


    //查询所有角色,包含对应user信息（多对多查询）
    /*
    select r.ID rid,r.ROLE_NAME,r.ROLE_DESC,u.* from role r
	left outer join user_role ur on r.id = ur.RID 			-- 先查询到所有角色对应的中间表
	left outer join user u on u.id = ur.UID							-- 再左联查询
     */
    List<Role> findAll();
}
