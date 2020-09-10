package cn.kk.service.impl;

import cn.kk.dao.IRoleDao;
import cn.kk.domain.Role;
import cn.kk.service.IRoleService;
import cn.kk.utils.UUIDutils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private IRoleDao roleDao;

    @Override
    public List<Role> findAll() throws Exception {
        return roleDao.findAll();
    }


    public void save(Role role) throws Exception{
        role.setId(UUIDutils.getUpperUUID());
        roleDao.save(role);
    }

    @Override
    public Role findById(String roleId) throws Exception {
        return roleDao.findById(roleId);
    }

    @Override
    public Role findRoleContainNoPermission(String roleId) throws Exception {
        return roleDao.findRoleContainNoPermission(roleId);
    }

    @Override
    public void addPermissionToRole(String roleId, String[] permissionIds) throws Exception {
        for (String permissionId : permissionIds) {
            roleDao.addPermissionToRole(roleId, permissionId);
        }
    }
}
