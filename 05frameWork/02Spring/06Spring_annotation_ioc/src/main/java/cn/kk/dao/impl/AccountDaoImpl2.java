package cn.kk.dao.impl;

import cn.kk.dao.IAccountDao;
import org.springframework.stereotype.Repository;

@Repository("accountDao2")
public class AccountDaoImpl2 implements IAccountDao {

    public void saveAccount() {
        System.out.println("保存Account2222222222");
    }
}
