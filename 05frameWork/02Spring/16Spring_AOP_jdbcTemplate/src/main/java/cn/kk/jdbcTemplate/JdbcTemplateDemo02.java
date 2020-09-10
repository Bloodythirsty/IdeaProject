package cn.kk.jdbcTemplate;

import cn.kk.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class JdbcTemplateDemo02 {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate jdbcTemplate = ac.getBean("jdbcTemplate", JdbcTemplate.class);

        //增删改，都用update
        //jdbcTemplate.update("insert into account(name,money) values(?,?)","eeee",1000f);

        //查询
        // List<Account> accounts = jdbcTemplate.query("select * from account where money > ?", new AccountRowMapper(), 1000f);
        // for(Account account:accounts)
        //     System.out.println("account = " + account);

        //聚合查询
        Integer integer = jdbcTemplate.queryForObject("select count(*) from account where money > ?", Integer.class, 1000f);
        System.out.println("integer = " + integer);
    }
}

/*
        定义Account的封装策略
 */
class AccountRowMapper implements RowMapper<Account>{
    // 把结果集中的数据，封装到Account，然后由spring把每个Account添加到集合
    public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
        Account account = new Account();
        account.setId(rs.getInt("id"));
        account.setName(rs.getString("name"));
        account.setMoney(rs.getFloat("money"));
        return account;
    }
}
