package cn.kk;

import cn.kk.dao.PlaceDao;
import cn.kk.dao.UserDao;
import cn.kk.pojo.Place;
import cn.kk.pojo.Province;
import cn.kk.pojo.User;
import cn.kk.service.IPlaceService;
import cn.kk.service.impl.ProvinceServiceImpl;
import com.github.pagehelper.PageInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@SpringBootTest
class BTravelApplicationTests {


    @Autowired
    UserDao userDao;

    @Test
    void testSave() throws Exception {
        User user = new User();
        user.setUsername("kk1");
        user.setPassword("kk");
        user.setEmail("9398@qq.com");
        userDao.saveUser(user);
        /*
             @Accessors(chain = true)  当user加这个注解 就能链式调用
         */
        user.setUsername("kk").setPassword("kk").setEmail("939855685@qq.com");
    }


    @Test
    void testFind() throws Exception {
        User kk = userDao.findByUsername(null);
        System.out.println("kk = " + kk);
    }

    @Autowired
    private ProvinceServiceImpl provinceService;

    @Test
    void testProvinceDao() throws Exception {
        List<Province> provinces = provinceService.findAllProvince(2,3);
        PageInfo<Province> provincePageInfo = new PageInfo<>(provinces);

        for (Province province : provincePageInfo.getList()) {
            System.out.println("province = " + province);
        }
    }

    @Test
    void testProvinceAdd() throws Exception {
        Province province = new Province();
        province.setName("kk").setTags("kk、qq");
        provinceService.saveProvince(province);
    }

    @Test
    void testDeletePro() throws Exception {
        provinceService.deleteProvince(13);
    }

    @Test
    void testUpdate() throws Exception {
        Province province = new Province();
        province.setId(14).setName("大黄河").setTags("宏伟！");
        provinceService.updateProvince(province);
    }

    @Autowired
    IPlaceService placeService;

    @Test
    void testPlace() throws Exception {
        List<Place> placeByProvinceId = placeService.findPlaceByProvinceId(1,2,7);
        for (Place place : placeByProvinceId) {
            System.out.println("place = " + place);
        }

    }

    @Autowired
    PlaceDao placeDao;

    @Test
    void testPlaceDao() throws Exception {
        Place place = new Place();
        // place.setName("公主坟3").setHottime(LocalDate.now());
        placeDao.savePlace(place);
    }

    @Test
    void testFindOne() throws Exception {
        String name = placeDao.findPlaceByName("麦积山哈");
        System.out.println("name = " + name);
    }
}
