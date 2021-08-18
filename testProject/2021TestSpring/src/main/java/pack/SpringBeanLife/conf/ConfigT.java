package pack.SpringBeanLife.conf;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;
import pack.SpringBeanLife.domain.Person;

/**
 * @author zhangkangkang
 * @date 2021/08/18 10:22
 */
@Configuration
public class ConfigT implements ApplicationContextAware {

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Person person = (Person) applicationContext.getBean("person");
        System.out.println(person.toString());
    }
}
