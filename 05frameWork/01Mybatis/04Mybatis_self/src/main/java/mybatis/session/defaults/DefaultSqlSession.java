package mybatis.session.defaults;

import mybatis.cfg.Configuration;
import mybatis.session.SqlSession;
import mybatis.session.proxy.MapperProxy;
import mybatis.utils.DateSourceUtil;

import java.lang.reflect.Proxy;
import java.sql.Connection;

/**
 *      sqlSession的实习类
 */

public class DefaultSqlSession implements SqlSession {

    private Configuration cfg;
    private Connection conn;

    public DefaultSqlSession(Configuration cfg) {
        this.cfg = cfg;
        conn = DateSourceUtil.getConnection(cfg);
    }

    /**
     *      用于创建代理对象
     * @param daoInterfaceClass， dao的接口字节码
     * @param <T>
     * @return
     */
    @Override
    public <T> T getMapper(Class<T> daoInterfaceClass) {
        return
                (T)Proxy.newProxyInstance(daoInterfaceClass.getClassLoader(),  //代理谁，就用谁的类加载器
                //daoInterfaceClass.getInterfaces(),    这是实体类获得接口的调用方法，次处本来就是接口，接口的接口，会出错
                new Class[]{daoInterfaceClass},
                new MapperProxy(cfg.getMappers(),conn));    //MapperProxy实现了InvocationHandler，包含mappers，conn，用于查找每一条Mapper

    }


    /**
     *      用于释放资源
     */
    @Override
    public void close() {
        if(conn != null) {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
