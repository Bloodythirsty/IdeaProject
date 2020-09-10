package cn.kk.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "cn.kk")
@EnableAspectJAutoProxy
public class SpringConfig {
}
