package mybatis.session;


/**
 *      自定义的，创建dao接口的代理对象
 */
public interface SqlSession {

    /**
     *      根据参数创建代理对象
     * @param daoInterfaceClass， dao的接口字节码
     * @param <T>
     * @return
     */
    <T> T getMapper(Class<T> daoInterfaceClass);    //泛型，先声明，后使用

    void close();
}
