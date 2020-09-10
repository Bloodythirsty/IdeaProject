package cn.kk.test;

import cn.kk.domain.Items;
import cn.kk.service.IItemsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:springContext.xml")
public class testSpring {

    @Resource(name = "itemsService")
    private IItemsService itemsService;

    @Test
    public void testSpringBean() {
        System.out.println("itemsService = " + itemsService);
    }

    @Test
    public void testMybatis() {
        Items i = itemsService.findById(8);
        System.out.println("i = " + i);
    }
}
