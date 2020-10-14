package cn.kk.dao;

import cn.kk.pojo.User;

public interface UserDao {


    /**
     *  登陆查询
     * @param id
     * @return
     * @throws Exception
     */
    public User findByUsername(String username)throws Exception;


    /**
     *  注册
     * @param user
     * @throws Exception
     */
    public void saveUser(User user) throws Exception;
}
