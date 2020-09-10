package cn.kk.service.impl;

import cn.kk.dao.IPermissionDao;
import cn.kk.dao.IProductDao;
import cn.kk.domain.Permission;
import cn.kk.service.IPermissionService;
import cn.kk.service.IProductService;
import cn.kk.utils.UUIDutils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements IPermissionService {

    @Autowired
    private IPermissionDao permissionDao;

    @Override
    public List<Permission> findAll() throws Exception {
        return permissionDao.findAll();
    }

    @Override
    public List<Permission> findPermissionByRoleIds(String id) throws Exception {
        return permissionDao.findPermissionByRoleIds(id);
    }

    @Override
    public void save(Permission permission) throws Exception {
        permission.setId(UUIDutils.getLowerUUID());
        permissionDao.save(permission);
    }
}
