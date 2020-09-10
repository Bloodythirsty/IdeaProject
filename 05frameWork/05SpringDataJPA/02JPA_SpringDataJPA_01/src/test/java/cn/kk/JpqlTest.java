package cn.kk;

import cn.kk.dao.ICustomerDao;
import cn.kk.domain.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:ApplicationContext.xml")
public class JpqlTest {
    /*
        使用客户名称查询客户
        jpql: from Customer where name = ?
     */

    @Autowired
    private ICustomerDao customerDao;

    @Test
    public void testFindByNameJPQL() {
        Customer customer = customerDao.findByNameJPQL("kkk");
        System.out.println("customer = " + customer);
    }

    @Test
    public void testByIdAndName() {
        // Customer customer = customerDao.findByIdAndName(5, "kkk");
        Customer customer = customerDao.findByIdAndName("kkk",5);
        System.out.println("customer = " + customer);
    }

    @Test
    @Transactional
    @Rollback(value = false)
    public void testUpdateJpql() {
        customerDao.updateById(3,"JpqlUpdate3");
    }


    @Test
    public void testSqlFindAll() {
        List<Customer> customers = customerDao.findAllBySql();
        for (Object customer : customers) {
            System.out.println("customer = " + customer);
        }
    }


    @Test
    public void testFindBySqlLike() {
        List<Customer> customers = customerDao.findBySqlLike("%王%");
        for (Customer customer : customers) {
            System.out.println("customer = " + customer);
        }
    }

    /*
            命名规则
     */

    @Test
    public void testFindByName() {
        Customer kkk = customerDao.findByName("kkk");
        System.out.println("kkk = " + kkk);
    }

    @Test
    public void testFindBy() {
        List<Customer> byNameLike = customerDao.findByNameLike("%王%");
        for (Customer customer : byNameLike) {
            System.out.println("customer = " + customer);
        }
    }

    /*
            根据命名规则查询：多条件查询
     */

    @Test
    public void testNameLikeAndIndustry() {
        List<Customer> customers = customerDao.findByNameLikeAndIndustry("%王%", "教育");
        for (Customer customer : customers) {
            System.out.println("customer = " + customer);
        }
    }
}
