package cn.kk;

import cn.kk.dao.IAccountDao;
import cn.kk.domain.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class TestJdbc {

    @Resource(name = "accountDao1")
    private IAccountDao accountDao;

    @Test
    public void testFindById() {
        Account a = accountDao.findById(1);
        System.out.println("a = " + a);
    }

    @Test
    public void testFindByName() {
        Account kk = accountDao.findByName("kk");
        System.out.println("kk = " + kk);
    }

    @Test
    public void testUpdate() {
        Account kk = accountDao.findByName("kk");
        kk.setName("kkUpdate");
        accountDao.updateAccount(kk);
    }
}
