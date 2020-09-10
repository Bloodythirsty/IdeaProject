package dao.impl;

import dao.UserDao;
import domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserDaoImpl implements UserDao {
    private SqlSessionFactory factory;

    public UserDaoImpl(SqlSessionFactory  factory){
        this.factory = factory;
    }

    @Override
    public List<User> findAll() {
        // 1. 使用工厂产生session
        SqlSession sqlSession = factory.openSession();
        //2 . 查询
        List<User> users = sqlSession.selectList("dao.UserDao.findAll");    // 参数：userDao.xml里面的namespace+方法名
        sqlSession.close();
        return users;
    }
}
