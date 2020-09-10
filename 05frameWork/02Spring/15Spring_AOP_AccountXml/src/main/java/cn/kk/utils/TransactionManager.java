package cn.kk.utils;

import java.sql.SQLException;

/*
        和事务相关的管理类
            1. 开启事务
            2. 提交事务
            3. 回滚
            4. 释放
 */
public class TransactionManager {

    private ConnectionUtils connectionUtils;

    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }

    /*
                开启事务
         */
    public void beginTransaction() {
        try {
            connectionUtils.getThreadConnection().setAutoCommit(false);     // 不开启自动提交
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    /*
            提交事务
     */
    public void commit(){
        try {
            connectionUtils.getThreadConnection().commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    /*
            回滚事务
     */
    public void rollback(){
        try {
            connectionUtils.getThreadConnection().rollback();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    /*
            释放
     */
    public void release(){
        try {
            connectionUtils.getThreadConnection().close();      //还到连接池
            connectionUtils.removeConnection();         //解绑
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
