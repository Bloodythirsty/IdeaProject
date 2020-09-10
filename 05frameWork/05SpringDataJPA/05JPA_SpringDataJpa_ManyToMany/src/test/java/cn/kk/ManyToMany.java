package cn.kk;

import cn.kk.dao.IRoleDao;
import cn.kk.dao.IUserDao;
import cn.kk.domain.Role;
import cn.kk.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:ApplicationContext.xml")
public class ManyToMany {

    @Autowired
    private IUserDao userDao;

    @Autowired
    private IRoleDao roleDao;

    /*
        保存一个用户，保存一个角色
     */
    @Transactional
    @Rollback(value = false)
    @Test
    public void testAdd() {
        User user = new User();
        user.setUserName("小李");

        Role role = new Role();
        role.setRoleName("程序员");

        //配置中间关系
        user.getRoleSet().add(role);
        role.getUserSet().add(user);    //再次添加，会出错（主键冲突）

        userDao.save(user);
        roleDao.save(role);
    }

    /*
        级联操作：解决上面两个都需要保存的问题
     */
    @Transactional
    @Rollback(value = false)
    @Test
    public void testAdd2() {
        User user = new User();
        user.setUserName("小李2");

        Role role = new Role();
        role.setRoleName("程序员2");

        //配置中间关系
        user.getRoleSet().add(role);

        userDao.save(user);
    }

    /*
        级联操作：解决上面两个都需要保存的问题
     */
    @Transactional
    @Rollback(value = false)
    @Test
    public void testCascadeDelete() {
        User one = userDao.findOne((long) 1);
        userDao.delete(one);
    }

    @Transactional
    @Rollback(value = false)
    @Test
    public void testCascadeDelete2() {
        Role one = roleDao.findOne((long) 2);
        roleDao.delete(one);        //没有维护中间表的一方，不能删除
    }
}
