package jedis.test;

import jdcbUtils.JdbcUtils;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class JdbcUtilsTest {

    @Test
    public void test1() throws SQLException {
        System.out.println(JdbcUtils.getDataSource());
        System.out.println(JdbcUtils.getConnection());
    }

}