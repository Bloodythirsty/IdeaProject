package cn.kk.service.impl;

import cn.kk.dao.IAccountDao;
import cn.kk.domain.Account;
import cn.kk.service.IAccountService;
import cn.kk.utils.TransactionManager;

import java.util.List;

/*
        事务的控制应该在service层
 */
public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao;
    private TransactionManager txManager;
    //Spring帮助注入
    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public void setTxManager(TransactionManager txManager) {
        this.txManager = txManager;
    }

    public List<Account> findAll() {
        try{
            //1. 开启事务
            txManager.beginTransaction();
            //2. 执行操作
            List<Account> accounts = accountDao.findAll();
            //3. 提交事务
            txManager.commit();
            //4. 返回结果
            return accounts;
        }catch(Exception e){
            //5. 回滚操作
            txManager.rollback();
            throw new RuntimeException(e);
        }finally{
            //6. 释放链接
            txManager.release();
        }
    }

    public Account findOne(Integer id) {
        return accountDao.findOne(id);
    }

    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
    }

    public void deleteAccount(Integer id) {
        accountDao.deleteAccount(id);
    }

    public void update(Account account) {
        accountDao.update(account);
    }

    public void transfer(String sourceName, String targetName, float money) {

        try{
            //1. 开启事务
            txManager.beginTransaction();
            //2. 执行
                //1. 根据名查询询转出账户
                Account sourceAccount = accountDao.findByName(sourceName);
                //2. 根据名称查询转入账户
                Account targetAccount = accountDao.findByName(targetName);
                //3. 转出账户减钱
                sourceAccount.setMoney(sourceAccount.getMoney() - money);
                //4. 转入账户加钱
                targetAccount.setMoney(targetAccount.getMoney() + money);
                //5. 更新转出账户
                accountDao.update(sourceAccount);
                // int i = 1/0;
                //6. 更新转入账户
                accountDao.update(targetAccount);
            //3. 提交
            txManager.commit();
            //4. 返回结果
        }catch( Exception e){
            //5. 异常回滚
            txManager.rollback();
            throw new RuntimeException(e);
        }finally {
            //6. 释放资源
            txManager.release();
        }


    }
}
