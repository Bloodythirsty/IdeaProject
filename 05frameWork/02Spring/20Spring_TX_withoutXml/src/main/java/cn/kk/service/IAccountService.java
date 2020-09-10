package cn.kk.service;

import cn.kk.domain.Account;

public interface IAccountService {

    Account findById(Integer id);

    void transfer(String sourceName, String targetName, Float money);
}
