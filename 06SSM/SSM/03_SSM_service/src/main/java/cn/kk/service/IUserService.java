package cn.kk.service;

import cn.kk.domain.Users;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService {
    public List<Users> findAll() throws Exception;

    void save(Users users) throws Exception;

    Users findById(String id) throws Exception;

    public Users findByIdAndNotRole(String id) throws Exception;

    public void addRoleToUser(String userId,String[] roleId) throws Exception;

}
