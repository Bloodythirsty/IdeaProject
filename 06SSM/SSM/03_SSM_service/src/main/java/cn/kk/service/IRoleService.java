package cn.kk.service;

import cn.kk.domain.Role;

import java.util.List;

public interface IRoleService {
    public List<Role> findAll() throws Exception;
    public void save(Role role) throws Exception;
    public Role findById(String roleId) throws Exception;
    public Role findRoleContainNoPermission(String roleId) throws Exception;
    public void addPermissionToRole(String roleId, String[] permissionIds) throws Exception;

}
