package pack.SpringBeanLife.beanPostProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Configuration;
import pack.SpringBeanLife.domain.Person;

/**
 * @author zhangkangkang
 * @date 2021/08/18 9:36
 */
@Configuration
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof Person) {
            System.out.println("MyBeanPostProcessor : postProcessBeforeInitialization。 " + bean.toString());
        }
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof Person) {
            System.out.println("MyBeanPostProcessor : postProcessAfterInitialization" + bean.toString());
        }
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
