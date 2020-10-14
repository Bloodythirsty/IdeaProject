package cn.kk;

import cn.kk.config.JdbcConfig;
import cn.kk.config.JdbcProperties;
import cn.kk.dao.UserMapper;
import cn.kk.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;


@SpringBootTest(classes = SpringbootApplication.class)
public class testDruid {

    @Autowired
    private DataSource dataSource;

    @Test
    void testDataSource() throws SQLException {
        dataSource.getConnection();
        System.out.println("dataSource = " + dataSource);
    }

    @Test
    void test() {
        JdbcProperties jdbcProperties = new JdbcProperties();
        System.out.println("jdbcProperties = " + jdbcProperties);
    }


    @Autowired
    UserMapper userMapper;
    @Test
    void testDruid() {
        List<User> users = userMapper.queryUserList();
        for (User user : users) {
            System.out.println("user = " + user);
        }
    }
}
