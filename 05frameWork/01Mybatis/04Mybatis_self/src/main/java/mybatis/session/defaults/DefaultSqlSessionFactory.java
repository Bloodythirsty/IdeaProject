package mybatis.session.defaults;

import mybatis.cfg.Configuration;
import mybatis.session.SqlSession;
import mybatis.session.SqlSessionFactory;

public class DefaultSqlSessionFactory implements SqlSessionFactory {


    private Configuration cfg;

    public DefaultSqlSessionFactory(Configuration cfg){
        this.cfg = cfg;
    }

    /**
     *      用于创建新的操作数据库对象
     * @return
     */
    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(cfg);
    }   //DefaultSqlSession包含cfg,conn
}
