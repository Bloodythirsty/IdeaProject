package pack.SpringBeanLife.beanPostProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;
import org.springframework.context.annotation.Configuration;
import pack.SpringBeanLife.domain.Person;

/**
 * @author zhangkangkang
 * @date 2021/08/18 10:35
 */
@Configuration
public class MyBeanPostProcessorAdaptor extends InstantiationAwareBeanPostProcessorAdapter {
    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        if(beanClass == Person.class){
            System.out.println("postProcessBeforeInstantiation " + beanName);
        }
        return super.postProcessBeforeInstantiation(beanClass, beanName);
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        if(bean instanceof Person){
            System.out.println("postProcessBeforeInstantiation" + bean.toString());
        }
        return super.postProcessAfterInstantiation(bean, beanName);
    }
}
