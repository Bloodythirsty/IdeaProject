package cn.kk.jdbcTemplate;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class JdbcTemplateDemo01 {
    public static void main(String[] args) {
        // 准备数据源（c3p0,druid），Spring的内置数据源
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/db4_spring01 ?useSSL=false&serverTimezone=GMT");
        driverManagerDataSource.setUsername("root");
        driverManagerDataSource.setPassword("root");
        //1. 创建jdbcTemplate对象
        JdbcTemplate jdbcTemplate = new JdbcTemplate(driverManagerDataSource);
        //2. 设置数据源
        // jdbcTemplate.setDataSource(driverManagerDataSource);
        //2. 执行操作
        jdbcTemplate.execute("insert into account(name,money) values('wang',1000) ");
    }
}
