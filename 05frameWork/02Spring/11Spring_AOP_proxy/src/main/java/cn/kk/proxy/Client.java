package cn.kk.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Client {

    public static void main(String[] args) {
        final Producer producer = new Producer();
        // producer.sell(1000f);

        /*
                动态代理：
                    1. 字节码，随用随创建，随用随加载
                    2. 作用：对方法增强
                    3. 分类：
                        1. 基于接口的动态代理
                        2. 基于子类的动态代码
                    4. 如何创建代理对象：用Proxy类中的newProxyInstance方法
                    5. 创建代理对象要求：代理类最少实现一个接口，如果没有，则不能实现
         */

        IProducer porxyProducer = (IProducer)Proxy.newProxyInstance(producer.getClass().getClassLoader(),
                producer.getClass().getInterfaces(),
                new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        //1. 获取参数
                        Float money = (Float)args[0];
                        //2. 判断当前方法
                        if ("sell".equals(method.getName())){
                            Object returnValue = null;
                            returnValue = method.invoke(producer,money*0.8f);
                            return returnValue;
                        }else {
                            return method.invoke(producer,args);
                        }
                    }
                });

        porxyProducer.sell(10000f);
    }
}
