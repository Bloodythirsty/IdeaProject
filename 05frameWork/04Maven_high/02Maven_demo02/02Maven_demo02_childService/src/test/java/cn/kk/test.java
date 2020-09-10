package cn.kk;

import cn.kk.service.IItemsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/springContext_Service.xml"})
//         "classpath:spring/springContext_Dao.xml"
public class test {

    @Resource(name = "itemsService")
    private IItemsService itemsService;

    @Test
    public void testService() {
        itemsService.transfer(1,3);
    }
}
