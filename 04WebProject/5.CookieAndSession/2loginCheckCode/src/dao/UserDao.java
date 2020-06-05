package dao;

import bean.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCutils;

/**
 * @author zkk;
 * @create 2020-03-31;
 */
public class UserDao     {

    //1. 用JDBCtemplate操作，简化sql操作
    //1.1 定义JSBCtemplate
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCutils.getDataSource());

    //2 编写login方法，查询数据库
    public User login(User loginUser){
        try {
            //2.1 编写sql
            String sql = "select * from userexample where username = ? and password = ?";
            //2.2 调用JdbcTemplate的query方法
            User user = jdbcTemplate.queryForObject(sql,                    //自己抓捕，正常返回1条，异常返回0条
                    new BeanPropertyRowMapper<User>(User.class),
                    loginUser.getUsername(), loginUser.getPassword());
            return user;
        } catch (DataAccessException e) {
            //e.printStackTrace();
            return null;
        }
    }
}
