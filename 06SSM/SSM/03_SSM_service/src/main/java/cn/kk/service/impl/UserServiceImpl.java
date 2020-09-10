package cn.kk.service.impl;

import cn.kk.dao.IUserDao;
import cn.kk.domain.Role;
import cn.kk.domain.Users;
import cn.kk.service.IUserService;
import cn.kk.utils.BCryptPasswordEncoderUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = null;
        try {
            users = userDao.findByUsername(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //返回spring-security提供的实体user
       // User user = new User(users.getUsername(),"{noop}"+users.getPassword(),getGrantedAuthority(users.getRolesList()));
        User user = new User(users.getUsername(),users.getPassword(),
                users.getStatus() != 0,true,true,true,getGrantedAuthority(users.getRolesList()));
        return user;
    }

    public List<SimpleGrantedAuthority> getGrantedAuthority(List<Role> roles){
        ArrayList<SimpleGrantedAuthority> sga = new ArrayList<>();
        for (Role role : roles) {
            SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority("ROLE_"+role.getRoleName().toUpperCase());
            sga.add(simpleGrantedAuthority);
        }
        return sga;
    }

    public List<Users> findAll() throws Exception {
        return userDao.findAll();
    }

    @Override
    public void save(Users users) throws Exception {
        users.setPassword(BCryptPasswordEncoderUtils.encodePassword(users.getPassword()));
        userDao.save(users);
    }

    /*
            三表查询
     */
    @Override
    public Users findById(String id) throws Exception {
        return userDao.findById(id);
    }

    @Override
    public Users findByIdAndNotRole(String id) throws Exception {
        return userDao.findByIdAndNotRole(id);
    }

    /*
            添加role
     */
    @Override
    public void addRoleToUser(String userId, String[] roleIds) throws Exception {
        if (roleIds != null && roleIds.length > 0) {
            for (String s : roleIds) {
                userDao.addRoleToUser(userId,s);
            }
        }
    }

}
