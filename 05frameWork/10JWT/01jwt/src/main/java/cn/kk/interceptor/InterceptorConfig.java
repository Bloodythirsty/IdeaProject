package cn.kk.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new JWTinterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/user/login");   //登陆不拦截，因为登陆才产生token
    }
}
