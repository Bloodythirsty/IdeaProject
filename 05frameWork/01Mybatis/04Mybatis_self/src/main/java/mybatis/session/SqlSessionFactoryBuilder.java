package mybatis.session;

import mybatis.cfg.Configuration;
import mybatis.session.defaults.DefaultSqlSessionFactory;
import mybatis.utils.XMLConfigBuilder;

import java.io.InputStream;

/**
 *  用于创建SqlSessionFactory对象
 */
public class SqlSessionFactoryBuilder {

    public SqlSessionFactory build(InputStream in){
        Configuration cfg = XMLConfigBuilder.loadConfiguration(in);
        return new DefaultSqlSessionFactory(cfg);

    }

}
