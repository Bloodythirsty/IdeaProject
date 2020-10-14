package cn.kk.config;

import cn.kk.interceptor.LogInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    /*
            java方式配置Interceptor

            SpringMVC中是写实现HandlerInterceptor的实现类，
            然后再xml配置
            <mvc:interceptors>
                <mvc:interceptor>
                    <mvc:mapping path="/user/*"/>
                    <!-- 不拦截的方法-->
                    <!--<mvc:exclude-mapping path=""/>-->
                    <bean class="cn.kk.interceptor.MyInterceptor" id="interceptor"/>
                </mvc:interceptor>
            </mvc:interceptors>
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LogInterceptor()).addPathPatterns("/**");
    }
}
