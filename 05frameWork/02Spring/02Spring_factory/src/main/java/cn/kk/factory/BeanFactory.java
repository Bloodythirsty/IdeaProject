package cn.kk.factory;


import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/*
        创建bean对象的工厂

        javaBean > 实体类

        他是创建service和dao对象的
 */
public class BeanFactory {
    //读取bean信息
    private static Properties propts;
    //存对象，实现单例
    private static Map<String,Object> beans;

    //使用静态代码块
    static{
        try {
            //注意使用类加载器加载资源（而不是路径）
            InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            propts = new Properties();
            propts.load(in);

            // 实例化容器(实现单例)
            beans = new HashMap<String, Object>();
            Enumeration<Object> keys = propts.keys();
            while (keys.hasMoreElements()){
                String key = (String) keys.nextElement();
                String path = propts.getProperty(key);
                Object o = Class.forName(path).newInstance();
                beans.put(key,o);
            }
        } catch (IOException e) {
            //初始化错误
            // e.printStackTrace();
            throw new ExceptionInInitializerError("初始化错误");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //根据名字获取bean
    public static Object getBean(String beanName){
        return beans.get(beanName);
    }
}
