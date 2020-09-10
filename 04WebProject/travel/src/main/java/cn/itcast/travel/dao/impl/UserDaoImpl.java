package cn.itcast.travel.dao.impl;

import cn.itcast.travel.dao.UserDao;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;


public class UserDaoImpl implements UserDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());    //简化操作

    @Override
    public User queryByUsername(User user) {
        String sql = "select * from tab_user where username = ?";
        //queryForObject默认不返回空，如果为空，则报异常，需要捕获处理
        try {
            User queriedUser = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), user.getUsername());
            return queriedUser;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean addUser(User user) {
        String sql = "insert into tab_user(username,password,name,birthday,sex,telephone,email,status,code) values(?,?,?,?,?,?,?,?,?)";
        int updateRows = template.update(sql, user.getUsername(),
                user.getPassword(),
                user.getName(),
                user.getBirthday(),
                user.getSex(),
                user.getTelephone(),
                user.getEmail(),
                user.getStatus(),
                user.getCode()
        );
        return updateRows!=0;
    }

    @Override
    public User findByCode(String code) {
        String sql = "select * from tab_user where code = ?";
        try{
            User findeUser = template.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), code);
            return findeUser;
        }catch (DataAccessException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void updateStatus(User user) {
        String sql = "update tab_user set status = 'Y' where uid = ?";
        template.update(sql,user.getUid());
    }

}
