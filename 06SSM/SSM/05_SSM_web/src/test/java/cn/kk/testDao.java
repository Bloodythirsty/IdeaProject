package cn.kk;

import cn.kk.dao.*;
import cn.kk.domain.*;
import cn.kk.service.*;
import cn.kk.utils.DataUtils;
import cn.kk.utils.UUIDutils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:ApplicationContext.xml")
public class testDao {
    
    @Autowired
    private IProductDao productDao;

    @Test
    public void testFindAll() throws Exception {
        List<Product> products = productDao.findAll();
        for (Product product : products) {
            System.out.println("product = " + product);
        }


    }

    @Test
    public void testFindById() throws Exception {
        Product byId = productDao.findById("e4213205ecc711ea8681f0761cf33ff6");
        System.out.println("byId = " + byId);
    }

    @Autowired
    private IOrdersService ordersService;

    @Test
    public void testOrderService() throws Exception {
        List<Orders> all = ordersService.findAll();
        for (Orders orders : all) {
            System.out.println("orders = " + orders);
        }

    }

    @Autowired
    private IOrderDao orderDao;

    @Test
    public void testOrderDao() throws Exception {
        List<Orders> all = orderDao.findAll();
        for (Orders orders : all) {
            System.out.println("orders = " + orders);
        }
    }

    @Test
    public void testOrderFindById() throws Exception {
        Orders byId = orderDao.findById("1fa394d6ed2811ea8681f0761cf33ff6");
        System.out.println("byId = " + byId);
    }

    @Test
    public void testPageHelper() throws Exception {
        PageHelper.startPage(2,2);
        List<Orders> ordersList = orderDao.findAll();
        PageInfo<Orders> pageInfo = new PageInfo<>(ordersList);
        System.out.println("pageInfo.getPages() = " + pageInfo.getPages());
        System.out.println("pageInfo.getPageNum() = " + pageInfo.getPageNum());
        System.out.println("pageInfo.getNextPage() = " + pageInfo.getNextPage());
        System.out.println("pageInfo.getPrePage() = " + pageInfo.getPrePage());
        System.out.println("pageInfo.getNavigatePages() = " + pageInfo.getNavigatePages());
        System.out.println("pageInfo.getTotal() = " + pageInfo.getTotal());
        System.out.println("pageInfo.getSize() = " + pageInfo.getSize());
        System.out.println("pageInfo.getPageSize() = " + pageInfo.getPageSize());
        List<Orders> list = pageInfo.getList();
        for (Orders orders : list) {
            System.out.println("orders = " + orders);
        }
    }


    @Autowired
    private IMemberDao memberDao;

    @Test
    public void testMemberDao() throws Exception {
        Member me = memberDao.findById("E61D65F673D54F68B0861025C69773DB");
        System.out.println("me = " + me);
    }


    @Autowired
    private ITravellerDao travellerDao;

    @Test
    public void testTravellerDao() throws Exception {
        List<Traveller> listByOrderId = travellerDao.findListByOrderId("1fa394d6ed2811ea8681f0761cf33ff6");
        for (Traveller traveller : listByOrderId) {
            System.out.println("traveller = " + traveller);
        }

    }

    @Autowired
    private IUserDao userDao;

    @Test
    public void testuSERdOA() throws Exception {
        Users kk = userDao.findByUsername("kk");
        System.out.println("kk = " + kk);
    }

    @Test
    public void testUserDaoFindAll() throws Exception {
        List<Users> all = userDao.findAll();
        for (Users users : all) {
            System.out.println("users = " + users);
        }
    }



    @Test
    public void testUUID() {
        String uuid = UUIDutils.getUpperUUID();
        System.out.println("uuid = " + uuid);
    }

    @Test
    public void testUserDaoSave() throws Exception {
        Users users = new Users();
        users.setId("8519988e26fb4ec2aea34b04132eb9c9");
        users.setEmail("5555@qq.com");
        userDao.save(users);
    }

    @Test
    public void testUserDaoFindById() throws Exception {
        Users byId = userDao.findById("52e2d4f9576c4bea838a54a654d89d84");
        System.out.println("byId = " + byId);
    }

    @Autowired
    private IPermissionService permissionService;

    @Test
    public void testPermissionService() throws Exception {
        List<Permission> all = permissionService.findAll();
        for (Permission permission : all) {
            System.out.println("permission = " + permission);
        }
    }


    @Autowired
    private IUserService userService;
    @Test
    public void testUserDaoNotRole() throws Exception {
        Users byIdAndNotRole = userService.findByIdAndNotRole("53e2d4f9576c4bea838a54a654d89d84");
        System.out.println("byIdAndNotRole = " + byIdAndNotRole);
    }

    @Autowired
    private IRoleService roleService;

    @Test
    public void testRoleService() throws Exception {
        Role role = roleService.findById("CFCA5D3355044961950AD900C4E2487B");
        System.out.println("role = " + role);
    }

    @Test
    public void testNoPermission() throws Exception {
        Role role = roleService.findRoleContainNoPermission("DFCA5D3355044961950AD900C4E2487B");
        System.out.println("role = " + role);
    }

    @Autowired
    private ISysLogService logService;

    @Test
    public void testLogService() throws Exception {
        SysLog sysLog = new SysLog();
        sysLog.setId(UUIDutils.getLowerUUID());
        logService.saveLog(sysLog);
    }



    @Test
    public void testLog() throws Exception {
        List<SysLog> all = logService.findAll();
        for (SysLog sysLog : all) {
            System.out.println("sysLog = " + sysLog.getVisitTimeStr());
        }
    }

    @Test
    public void testDateUtils() {
        Date date = new Date();
        System.out.println("date = " + date.toString());

        String date1 = DataUtils.DataToString(date);
        System.out.println("date1 = " + date1);

        Date date2 = DataUtils.StringToData(date1);
        System.out.println("date2.toString() = " + date2.toString());

    }
}
