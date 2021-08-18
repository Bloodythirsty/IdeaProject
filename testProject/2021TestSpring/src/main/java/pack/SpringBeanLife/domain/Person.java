package pack.SpringBeanLife.domain;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author zhangkangkang
 * @date 2021/08/18 9:34
 */
@Component
public class Person implements InitializingBean, DisposableBean, BeanNameAware {
    @Value("${person.name}")
    private String name;
    @Value("${person.age}")
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Person() {
        System.out.println("no args Constructor");
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
        System.out.println("constructor : " + this.getName());
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("postConstruct:"+ this.getName());
    }

    public void initMethod(){
        System.out.println("initMethod:"+this.getName());
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet : " + this.getName());
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("preDestroy");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean : destroy");
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("beanNameAware : " + s);
    }
}
