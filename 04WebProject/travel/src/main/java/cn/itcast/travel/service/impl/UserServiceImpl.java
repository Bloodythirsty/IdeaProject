package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.UserDao;
import cn.itcast.travel.dao.impl.UserDaoImpl;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.UserService;
import cn.itcast.travel.util.MailUtils;
import cn.itcast.travel.util.UuidUtil;

public class UserServiceImpl implements UserService {

    /**
     * 注册用户
     * @return
     * @param user
     */
    @Override
    public boolean regist(User user) {
        /*
        根据用户名查询：
            存在，返回false
            不存在，返回true
         */
        //1. 查询user
        UserDao userDao = new UserDaoImpl();
        User queriedUser = userDao.queryByUsername(user);
        if (queriedUser != null){
            //查询已经有：注册失败
            return false;
        }
        //2.
        //2.1 设置激活码
        user.setCode(UuidUtil.getUuid());
        //2.2 设置status
        user.setStatus("N");
        //3. 邮件正文，把从客户端获取到的验证码一起发送给servlet
        String content = "<a href='http://localhost:80/travel/user/active?code=" + user.getCode()
                +"'>点击激活</a>";
        //MailUtils.sendMail("794908594@qq.com",content,user.getUsername()+"的激活邮件");
        MailUtils.sendMail("monst1777@gmail.com",content,user.getUsername()+"的激活邮件");

        return userDao.addUser(user);
    }

    @Override
    public Boolean active(String code) {
        UserDao userDao = new UserDaoImpl();
        User findedUser = userDao.findByCode(code);
        if (findedUser != null){
            // 不为空，调用dao的修改激活状态的方法
            userDao.updateStatus(findedUser);
            return true;
        }
        return false;
    }

    @Override
    public User login(User user) {
        UserDao userDao = new UserDaoImpl();
        return userDao.queryByUsername(user);
    }

}
