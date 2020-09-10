package cn.kk.JpaUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
/*
        创建工厂的时候比较浪费资源
        设置工具类,创建一个公共的factory,下一使用EntityManager,直接获取即可

        因为是static,所以只会通过静态代码块加载一次
 */

public class JPAUtils {

    private static EntityManagerFactory factory;

    static {
        //1. 加载配置文件
        factory = Persistence.createEntityManagerFactory("myJpa");
    }

    //2. 创建实体管理类
    public static EntityManager getEntityManager(){
        return factory.createEntityManager();
    }
}
