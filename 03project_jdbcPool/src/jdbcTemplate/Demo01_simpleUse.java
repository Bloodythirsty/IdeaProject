package jdbcTemplate;

import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCutils;

/**
 * @author zkk;
 * @create 2019-12-08;
 */
public class Demo01_simpleUse {
    public static void main(String[] args) {
        //1.导入jar包,connector包，及其五个Sring包
        //2.创建JdbcTemplate对象
        JdbcTemplate jt = new JdbcTemplate(JDBCutils.getDataSource());
        //3.调用方法(更新db4中user表第一条)
        String sql = "UPDATE user SET password = ? WHERE id = ?";
       int count =  jt.update(sql, "123456", 1);
        System.out.println("count = " + count);

    }
}
