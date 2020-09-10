package cn.kk.dao.impl;

import cn.kk.dao.IUserDao;
import cn.kk.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserDaoImpl implements IUserDao {

    private SqlSessionFactory factory;

    public UserDaoImpl (SqlSessionFactory factory){
        this.factory = factory;
    }

    @Override
    public List<User> findAll() {
        //1. 根据factory获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //2 查询
        List<User> users = sqlSession.selectList("cn.kk.dao.IUserDao.findAll"); //参数就是能获取配置信息的key，IUserDao.xml里面的namespace+id
        //3. 释放资源
        sqlSession.close();

        return users;
    }

    @Override
    public void saveUser(User user) {
        SqlSession sqlSession = factory.openSession();
        sqlSession.insert("cn.kk.dao.IUserDao.saveUser",user);  //传入参数，在xml里面获取
        //3. 提交事务
        sqlSession.commit();
        sqlSession.close();

    }

    @Override
    public void updateUser(User user) {
        SqlSession sqlSession = factory.openSession();
        sqlSession.update("cn.kk.dao.IUserDao.updateUser",user);    //不加user参数，默认新增一条
        //3. 提交事务
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void deleteUser(int id) {
        SqlSession sqlSession = factory.openSession();
        sqlSession.delete("cn.kk.dao.IUserDao.deleteUser",id);
        //3. 提交事务
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public User findById(int id) {
        SqlSession sqlSession = factory.openSession();
        User user = sqlSession.selectOne("cn.kk.dao.IUserDao.findById",id);
        sqlSession.close();
        return user;
    }

    @Override
    public List<User> findNameByLike(String s) {
        SqlSession sqlSession = factory.openSession();
        List<User> users = sqlSession.selectList("cn.kk.dao.IUserDao.findNameByLike",s);
        sqlSession.close();
        return users;
    }

    @Override
    public int findTotal() {
        SqlSession sqlSession = factory.openSession();
        Integer count= sqlSession.selectOne("cn.kk.dao.IUserDao.findTotal");
        sqlSession.close();
        return count;
    }
}
