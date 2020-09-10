package mybatis.session.proxy;

import mybatis.cfg.Mapper;
import mybatis.utils.Executor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Map;

public class MapperProxy implements InvocationHandler {

    // mapper得key是 ： 全限定名+方法名
    private Map<String,Mapper> mappers;                 // 因为要用到sql和返回类型，所以定义sql
    private Connection conn;

    public MapperProxy(Map<String, Mapper> mappers, Connection conn) {
        this.mappers = mappers;
        this.conn = conn;
    }

    /**
     *          用于增强方法：其实就是调用selectList方法
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 1. 获取方法名
        String methodName = method.getName();
        //2. 获取方法所在类得名称(全限定名)
        String className = method.getDeclaringClass().getName();
        //3. 组合key
        String key = className+"."+methodName;
        //4. 获取mappers里面得Mapper对象
        Mapper mapper = mappers.get(key);
        //5. 判断是否获取到
        if (mapper == null){
            throw new IllegalArgumentException("传入参数有误");
        }
        //6 . 调用工具类，查询
        return new Executor().selectList(mapper,conn);

    }
}
