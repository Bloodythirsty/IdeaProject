package cn.kk;

import cn.kk.dao.IAccountDao;
import cn.kk.domain.Account;
import cn.kk.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class TestJdbc {

    @Resource(name = "accountService")
    private IAccountService accountService;

    @Test
    public void testTransfer() {
        accountService.transfer("aaa","bbb",500f);
    }
}
