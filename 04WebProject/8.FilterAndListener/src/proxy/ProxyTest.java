package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {
    public static void main(String[] args) {

        //先使用正常对象
        Lenovo lenovo = new Lenovo();
//        String sale = lenovo.sale(8);
//        System.out.println("sale = " + sale);

        //使用代理对象
        /**
         三个参数：
         1. 类加载器：真实对象.getClass().getClassLoader()
         2. 接口数组：真实对象.getClass().getInterfaces()
         3. 处理器： new InvocationHandler()
         */
        SaleComputer proxyLenovo = (SaleComputer)Proxy.newProxyInstance(lenovo.getClass().getClassLoader(), lenovo.getClass().getInterfaces(), new InvocationHandler() {
            //代理逻辑编写的方法，所有代理对象调用的方法都会触发该方法执行
            /*
            三个参数：
            1. proxy：代理对象
            2. method：代理对象调用的方法，被封装的对象
            3. args：代理对象调用方法时，传递的实际参数
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                System.out.println("invoke ");
//                System.out.println(method.getName());
//                return null;

                //1. 增强参数
                //1.1 判断是否是sale方法
                if (method.getName().equals("sale")){
                    //1.2 增强参数
                    double money = (double) args[0];
                    money *= 0.85;
                    //使用真实对象调用该方法
                    String invoke = (String)method.invoke(lenovo, money);
                    //2. 增强返回结果
                    //返回结果
                    System.out.println("包邮");
                    //3. 增强方法体
                    return invoke+"送一个鼠标垫";
                }else {
                    //使用真实对象调用该方法
                    Object invoke = method.invoke(lenovo, args);
                    //返回结果
                    return invoke;
                }




            }
        });
        String sale1 = proxyLenovo.sale(8);
        System.out.println("sale1 = " + sale1);
        proxyLenovo.show();
    }
}

