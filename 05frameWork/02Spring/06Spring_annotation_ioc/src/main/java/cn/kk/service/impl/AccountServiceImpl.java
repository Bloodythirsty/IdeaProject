package cn.kk.service.impl;

import cn.kk.dao.IAccountDao;
import cn.kk.dao.impl.AccountDaoImpl;
import cn.kk.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/*
       XML配置：<bean id="accountService" class="cn.kk.service.impl.AccountServiceImpl"
                scope=""  init-method="" destroy-method="">
                    <property name="" value=""|ref=""></property>
                </bean>

 */
// @Component
// @Controller
@Service
// @Scope("prototype")
public class AccountServiceImpl implements IAccountService {

    // private IAccountDao iAccountDao = new AccountDaoImpl();
    // @Autowired
    // @Qualifier("accountDao1")
    @Resource(name = "accountDao1")
    private IAccountDao accountDao;

    public AccountServiceImpl( ){
        System.out.println("对象被创建了");
    }

    public void saveAccount() {
        accountDao.saveAccount();
    }

    @PostConstruct
    public void init(){
        System.out.println("init");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("destroy");
    }
}
