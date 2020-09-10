package cn.kk.cjlib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class Client {

    public static void main(String[] args) {
        final Producer producer = new Producer();
        // producer.sell(1000f);

        /*
                子类动态代理：
                    1. 字节码，随用随创建，随用随加载
                    2. 作用：对方法增强
                    3. 子类动态代理：
                        1. 涉及的类：Enhancer
                        2. 提供者：第三方cglib库
                    4. 如何创建代理对象：用Enhancer类中的create方法
                    5. 创建代理对象要求：代理类不能是最终类
                    6. Create方法参数
                        1. Class：指定被代理对象字节码
                        2. Callback：一般写的是该接口的子接口实现类，MethodInterceptor
         */
        Producer cglibProducer = (Producer)Enhancer.create(producer.getClass(), new MethodInterceptor() {
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                if ("sell".equals(method.getName())) {
                    Float money = (Float) objects[0];
                    return method.invoke(producer, money * 0.8f);
                } else {
                    return method.invoke(producer,objects);
                }
            }
        });


        cglibProducer.sell(10000f);
        cglibProducer.afterSell(1000f);
    }
}
