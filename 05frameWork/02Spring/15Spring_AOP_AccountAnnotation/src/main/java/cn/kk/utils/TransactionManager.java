package cn.kk.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.sql.SQLException;

/*
        和事务相关的管理类
            1. 开启事务
            2. 提交事务
            3. 回滚
            4. 释放
 */

@Component("txManager")
@Aspect
public class TransactionManager {

    @Resource(name = "connectionUtils")
    private ConnectionUtils connectionUtils;

    @Pointcut("execution(* cn.kk.service.impl.*.*(..))")
    public void pt1(){}

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

    @Around("pt1()")
    public void roundAdvice(ProceedingJoinPoint pjp){
        Object rtValue = null;
        try{
            beginTransaction();

            Object[] args = pjp.getArgs();
            pjp.proceed(args);

            commit();
        }catch (Throwable throwable) {
            rollback();
            throw new RuntimeException(throwable);
        } finally {
            release();
        }
    }
}
