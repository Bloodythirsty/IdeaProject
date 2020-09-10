package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/*
        配置类：
            1. 作用：与bean.xml一样
 */
// @Configuration
@ComponentScan(basePackages = {"cn.kk"})
@Import(JdbcConfig.class)
@PropertySource("classpath:cn/kk/jdbc.properties")    //classpath:表示后面的路径是类路径
public class SpringConfiguration {

}
