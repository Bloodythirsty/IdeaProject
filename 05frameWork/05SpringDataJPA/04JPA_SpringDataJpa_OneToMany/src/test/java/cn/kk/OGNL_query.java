package cn.kk;

import cn.kk.dao.ICustomerDao;
import cn.kk.dao.ILinkManDao;
import cn.kk.domain.Customer;
import cn.kk.domain.Linkman;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:ApplicationContext.xml")
public class OGNL_query {

    @Autowired
    private ICustomerDao customerDao;

    @Autowired
    private ILinkManDao linkManDao;

    /*
        findOne是离级加载
                一查多

     */
    @Test
    @Transactional
    public void testOGNL1() {
        Customer one = customerDao.findOne(1);
        System.out.println("one = " + one);
        System.out.println("one.getLinkMans() = " + one.getLinkMans());
    }

    /*
        getOne是延迟加载， 真正需要的时候才去查询
        一查多
     */
    @Test
    @Transactional
    public void testOGNL2() {
        Customer one = customerDao.getOne(1);
        System.out.println("one = " + one);
        System.out.println("one.getLinkMans() = " + one.getLinkMans());
    }

    @Test
    //@Transactional
    public void testOGNL3() {
        Linkman linkManDaoOne = linkManDao.findOne(6);
        System.out.println("linkManDaoOne = " + linkManDaoOne);
        System.out.println("linkManDaoOne.getCustomer() = " + linkManDaoOne.getCustomer());
    }


}
