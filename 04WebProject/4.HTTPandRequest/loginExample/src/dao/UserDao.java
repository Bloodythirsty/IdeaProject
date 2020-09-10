package dao;

import kk.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

/**
 * @author zkk;
 * @create 2020-03-25;
 */
/*
    操作db1数据库中serexample表的类
 */
public class UserDao {

    private JdbcTemplate  jdbcTemplate= new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     *
     * @param loginUser 只有用户名和密码
     * @return   user包含用户全部数据
     */
    public User login(User loginUser){      //用户从页面填写的
        try {
            //1. 编写sql
            String sql = "select * from userexample where username = ? and password = ?";
            //2. 调用query方法
            User user = jdbcTemplate.queryForObject(sql,                //查询一条结果
                    new BeanPropertyRowMapper<User>(User.class),        //封装类的类型
                    loginUser.getUsername(),loginUser.getPassword());   //注入：sql里面两个问号，注入两个值

            return user;
        } catch (DataAccessException e) {
            //e.printStackTrace();   记录日志
            return null;
        }
    }
}
