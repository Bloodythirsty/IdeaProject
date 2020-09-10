package cn.kk.dao.impl;

import cn.kk.dao.IAccountDao;
import cn.kk.domain.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

public class AccountDaoImpl extends JdbcDaoSupport implements IAccountDao {

    public Account findById(Integer id) {
        List<Account> accounts = getJdbcTemplate().query("select * from account where id = ?",
                new BeanPropertyRowMapper<Account>(Account.class), id);
        return accounts.isEmpty() ? null : accounts.get(0);     //因为id唯一
    }

    public Account findByName(String name) {
        List<Account> accounts = getJdbcTemplate().query("select * from account where name = ?",
                new BeanPropertyRowMapper<Account>(Account.class), name);
        if (accounts.isEmpty()){
            return null;
        }
        if (accounts.size() > 1){
            throw new RuntimeException("结果集不唯一");
        }
        return accounts.get(0);
    }

    public void updateAccount(Account account) {
        getJdbcTemplate().update("update account set name = ?, money = ? where id = ?",account.getName(),account.getMoney(),account.getId());
    }
}
