package cn.kk.service;

import cn.kk.pojo.User;

public interface IUserService {

    public void saveUser(User user) throws Exception;

    public User login(User user)throws Exception;

}
