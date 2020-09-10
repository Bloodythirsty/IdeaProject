package cn.kk.factory;

import cn.kk.domain.Account;
import cn.kk.service.IAccountService;
import cn.kk.utils.TransactionManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

public class BeanFactory {

    private IAccountService accountService ;
    private TransactionManager txManager;

    // 使用Spring注入
    public final void setAccountService(IAccountService accountService) {
        this.accountService = accountService;
    }
    // 使用Spring注入
    public void setTxManager(TransactionManager txManager) {
        this.txManager = txManager;
    }

    /*
                获取代理对象
         */
    public IAccountService getAccountService() {
        return (IAccountService)Proxy.newProxyInstance(accountService.getClass().getClassLoader(),
                accountService.getClass().getInterfaces(),
                new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object returnValue = null;
                        if ("test".equals(method.getName())){
                            return method.invoke(accountService,args);
                        }
                        try{
                            //1. 开启事务
                            txManager.beginTransaction();
                            //2. 执行操作
                            returnValue = method.invoke(accountService, args);
                            //3. 提交事务
                            txManager.commit();
                            //4. 返回结果
                            return returnValue;
                        }catch(Exception e){
                            //5. 回滚操作
                            txManager.rollback();
                            throw new RuntimeException(e);
                        }finally{
                            //6. 释放链接
                            txManager.release();
                        }
                    }
                });
    }
}
