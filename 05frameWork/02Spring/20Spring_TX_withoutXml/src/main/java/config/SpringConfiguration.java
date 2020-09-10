package config;

/*
        配置类
 */

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = "cn.kk")
@Import({JdbcConfiguration.class, TransactionConfiguration.class})
@PropertySource("classpath:jdbc.properties")
@EnableTransactionManagement
public class SpringConfiguration {

}
