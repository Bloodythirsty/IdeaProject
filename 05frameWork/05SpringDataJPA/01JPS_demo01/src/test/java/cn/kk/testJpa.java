package cn.kk;

import cn.kk.JpaUtils.JPAUtils;
import cn.kk.domain.Customer;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class testJpa {
    /*
           5. jpa的操作步骤:
                1. 加载配置文件，创建工厂对象（实体类管理工厂）
                2. 通过实体管理类工厂获取实体管理器
                3. 获取事务对象，开启事务
                4. 完成增删改
                5. 提交事务
                6. 释放资源
     */
    @Test
    public void testSave() {
        // 1. 加载配置文件，创建工厂对象（实体类管理工厂）
        // EntityManagerFactory factory = Persistence.createEntityManagerFactory("myJpa");
        // 2. 通过实体管理类工厂获取实体管理器
        EntityManager entityManager = JPAUtils.getEntityManager();
        // 3. 获取事务对象，开启事务
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        // 4. 完成增删改:保存客户到数据库
        Customer customer = new Customer();
        customer.setCust_name("康康12334");
        customer.setCust_phone("13279257441");
        // 保存
        entityManager.persist(customer);
        // 5. 提交事务
        transaction.commit();
        // 6. 释放资源
        entityManager.close();
        // factory.close();
    }


    @Test
    public void testFindById() {
        EntityManager entityManager = JPAUtils.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        //操作
        Customer customer = entityManager.find(Customer.class, 1);
        System.out.println("customer = " + customer);

        transaction.commit();

        //释放
        entityManager.close();
    }

    @Test
    public void testGetReference() {
        EntityManager entityManager = JPAUtils.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        //操作
        Customer customer = entityManager.getReference(Customer.class, 1);
        System.out.println("customer = " + customer);

        transaction.commit();

        //释放
        entityManager.close();
    }


    @Test
    public void testDelete() {
        EntityManager entityManager = JPAUtils.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();


        Customer customer1 = entityManager.find(Customer.class, 2);
        //操作
        entityManager.remove(customer1);

        transaction.commit();

        //释放
        entityManager.close();
    }

    @Test
    public void testUpdate() {
        EntityManager entityManager = JPAUtils.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();


        Customer customer1 = entityManager.find(Customer.class, 1);
        customer1.setCust_name("update");
        //操作
        entityManager.merge(customer1);

        transaction.commit();

        //释放
        entityManager.close();
    }
}
