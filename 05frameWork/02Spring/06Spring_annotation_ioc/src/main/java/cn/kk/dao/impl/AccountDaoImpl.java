package cn.kk.dao.impl;

import cn.kk.dao.IAccountDao;
import org.springframework.stereotype.Repository;

@Repository("accountDao1")
public class AccountDaoImpl implements IAccountDao {

    public void saveAccount() {

        System.out.println("保存Account1111");
    }

    public static void main(String[] args) {

    }
}
