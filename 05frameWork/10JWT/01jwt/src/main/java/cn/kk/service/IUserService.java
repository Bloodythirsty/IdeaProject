package cn.kk.service;

import cn.kk.poji.User;

public interface IUserService {
    User findByUsername(String username);
}
