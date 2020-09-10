package cn.kk;

import cn.kk.dao.ICustomerDao;
import cn.kk.domain.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:ApplicationContext.xml")
public class CustomerTest {

    @Resource(name = "ICustomerDao")
    private ICustomerDao customerDao;

    /*
            根据主键查找
     */
    @Test
    public void testFindOne() {
        Customer customer = customerDao.findOne(1);
        System.out.println("customer = " + customer);
    }

    /*
            save：保存或者更新
                保存：传递的对象没有主键id
                更新：传递的对象有主键id
     */
    @Test
    public void testSave() {
        Customer customer = new Customer();
        customer.setId(4);
        customer.setName("testJpaSave");
        customerDao.save(customer);
    }

    /*
            删除
     */

    @Test
    public void testDelete() {
        customerDao.delete(8);
    }

    /*
            查询所有
     */

    @Test
    public void testFindAll() {
        List<Customer> customerList = customerDao.findAll();
        for (Customer customer : customerList) {
            System.out.println("customer = " + customer);
        }
    }

    /*
        测试统计
     */
    @Test
    public void testCount() {
        long count = customerDao.count();
        System.out.println("count = " + count);
    }

    /*
            判断是否存在
            传统：
                1. 查询判断是否为null
                2. 查询id为4的个数，大于0，则存在
     */
    @Test
    public void testExist() {
        boolean exists = customerDao.exists(1);
        System.out.println("exists = " + exists);
    }


    /*

    @Transactional  :保证getOne正常运行
     */

    @Test
    @Transactional
    public void testGetOne() {
        Customer C = customerDao.getOne(1);
        System.out.println("C = " + C);
    }


    @Test
    public void testPage() {
        Pageable pageable = new PageRequest(2,2,new Sort(Sort.Direction.DESC));
        Page<Customer> all = customerDao.findAll(pageable);
        System.out.println("all = " + all);
    }

}
