package cn.kk;

import cn.kk.dao.ICustomerDao;
import cn.kk.dao.ILinkManDao;
import cn.kk.domain.Customer;
import cn.kk.domain.Linkman;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:ApplicationContext.xml")
public class TestOneToMany {

    @Autowired
    private ICustomerDao customerDao;

    @Autowired
    private ILinkManDao linkManDao;

    /*
            下面测试的效果：
                客户和联系人独立保存到表中，联系人外键没有值
            原因：
                实体类中没有配置关系
     */
    @Test
    @Transactional(propagation = Propagation.REQUIRED,readOnly = false)
    @Rollback(value = false)        //不自动回滚
    public void testAdd() {
        //创建一个客户，创建一个联系人
        Customer customer = new Customer();
        customer.setName("百度");

        Linkman linkman = new Linkman();
        linkman.setName("小百度");

        //配置外键关系：即在集合中加入linkman
        // 即一对应的表中设置 更新外键
        //两条inset，一条update
        customer.getLinkMans().add(linkman);

        customerDao.save(customer);
        linkManDao.save(linkman);
    }

    @Test
    @Transactional(propagation = Propagation.REQUIRED,readOnly = false)
    @Rollback(value = false)        //不自动回滚
    public void testAdd1() {
        //创建一个客户，创建一个联系人
        Customer customer = new Customer();
        customer.setName("百度2");

        Linkman linkman = new Linkman();
        linkman.setName("小百度2");

        //配置外键关系：在多的一方加入一的一方
        // 只发送了两条insert语句
        linkman.setCustomer(customer);

        //customerDao.save(customer);
        linkManDao.save(linkman);
    }

    @Test
    @Transactional(propagation = Propagation.REQUIRED,readOnly = false)
    @Rollback(value = false)        //不自动回滚
    public void testAdd2() {
        //创建一个客户，创建一个联系人
        Customer customer = new Customer();
        customer.setName("百度4");

        Linkman linkman = new Linkman();
        linkman.setName("小百度4");

        customer.getLinkMans().add(linkman);

        customerDao.save(customer);
        //linkManDao.save(linkman);
    }

    @Test
    @Transactional
    @Rollback(value = false)
    public void testCascadeSave() {
        //创建一个客户，创建一个联系人
        Customer customer = new Customer();
        customer.setName("百度1");

        Linkman linkman = new Linkman();
        linkman.setName("小百度1");

        //设置关系：即互相添加
        customer.getLinkMans().add(linkman);
        linkman.setCustomer(customer);

        //级联添加：添加主表，从表也会添加
        customerDao.save(customer);
    }


    /*
        级联删除：
            删除客户，也删除联系人
     */
    @Test
    @Transactional
    @Rollback(value = false)
    public void testCascadeDelete() {
        //1. 查询客户
        Customer one = customerDao.findOne(1);
        //2. 删除客户
        customerDao.delete(one);
    }

    /*
        级联更新：
     */
    @Test
    @Transactional
    @Rollback(value = false)
    public void testCascadeUpdate() {
        //1. 查询客户
        Customer one = customerDao.findOne(1);

        one.setName("k1");
        //2. 更新客户
        customerDao.save(one);
    }


    @Test
    @Transactional
    public void testFind() {
        Customer one = customerDao.findOne(1);
        System.out.println("one = " + one);
        System.out.println("one.getLinkMans() = " + one.getLinkMans());
    }
}
