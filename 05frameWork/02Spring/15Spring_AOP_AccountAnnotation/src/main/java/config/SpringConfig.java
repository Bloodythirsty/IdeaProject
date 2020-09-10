package config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = "cn.kk")
@Import(JdbcConfig.class)
@EnableAspectJAutoProxy
public class SpringConfig {

}
