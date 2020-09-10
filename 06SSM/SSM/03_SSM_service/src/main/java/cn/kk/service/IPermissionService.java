package cn.kk.service;

import cn.kk.domain.Permission;

import java.util.List;

public interface IPermissionService {
    List<Permission> findAll() throws Exception;
    List<Permission> findPermissionByRoleIds(String id ) throws Exception;
    void save(Permission permission) throws Exception;
}
