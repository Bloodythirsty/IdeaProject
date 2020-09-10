package cn.kk;

import cn.kk.JpaUtils.JPAUtils;
import com.sun.org.apache.regexp.internal.RE;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class testJPQL {

    /*
        查询全部
        sql：select * from cst_customer
        jpql: from cn.kk.domain.Customer
     */
    @Test
    public void testFindAll() {
        EntityManager entityManager = JPAUtils.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        // 查询全部
        String jpql = "from cn.kk.domain.Customer";
        //创建query对象，query对象才是执行jpql的对象
        Query query = entityManager.createQuery(jpql);
        //发送查询，封装结果
        List resultList = query.getResultList();

        for (Object o : resultList) {
            System.out.println("o = " + o);
        }

        transaction.commit();
        entityManager.close();
    }


    /*
        排序查询：倒序查询全部
        sql：select * from cst_customer order by cust_id（表中主键） DESC
        jpql: from Customer order by cust_id(实体类中主键) DESC
     */

    @Test
    public void testDESC() {
        EntityManager entityManager = JPAUtils.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        String s = "from Customer order by cust_id DESC";
        Query query = entityManager.createQuery(s);
        List resultList = query.getResultList();
        for (Object o : resultList) {
            System.out.println("o = " + o);
        }

        transaction.commit();
        entityManager.close();
    }

    /*
            统计客户的总人数
            sql：select count(*) from cust_customer
            jpql：select count(cust_id) from Customer
     */
    @Test
    public void testTongJi() {
        EntityManager entityManager = JPAUtils.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        String s = "select count(cust_id) from Customer ";
        Query query = entityManager.createQuery(s);
        Object singleResult = query.getSingleResult();
        System.out.println("singleResult = " + singleResult);

        transaction.commit();
        entityManager.close();
    }

    /*
            分页查询:从0开始查，每次查三条
            sql：select * from cust_customer limit 0,3
            sql中从第0条开始查，0可以省略：select * from cust_customer limit 3
            jpql：from Customer
     */
    @Test
    public void testPaged() {

        EntityManager entityManager = JPAUtils.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        //1. 根据jpql语句，创建query对象
        String s = "from Customer ";
        Query query = entityManager.createQuery(s);
        //2. 对参数赋值  --分页参数
        //2.1 起始索引
        query.setFirstResult(0);
        //2.2 每页查询条数
        query.setMaxResults(3);
        //3. 封装结果
        List resultList = query.getResultList();
        for (Object o : resultList) {
            System.out.println("o = " + o);
        }


        transaction.commit();
        entityManager.close();
    }

    /*
            条件查询：模糊查询，查询名字以王开头的客户

            sql：select * from cst_customer where cust_name like '王%';
            jpql：from Customer where cust_name like ?
     */

    @Test
    public void testCondition() {

        EntityManager entityManager = JPAUtils.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        //1. 根据jpql语句，创建query对象
        String s = "from Customer where cust_name like ?";
        Query query = entityManager.createQuery(s);
        //2. 对参数赋值  --占位符参数
        query.setParameter(1,"王%");
        //3. 封装结果
        List resultList = query.getResultList();
        for (Object o : resultList) {
            System.out.println("o = " + o);
        }

        transaction.commit();
        entityManager.close();

    }
}
