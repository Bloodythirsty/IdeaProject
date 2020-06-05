package druid;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * @author zkk;
 * @create 2019-12-07;
 */
public class Demo01_druid {
    public static void main(String[] args) throws Exception {
        //1.导包： druid-1.0.9.jar（记得驱动）
        //2.配置文件：
        //3.加载配置文件
        Properties ppts =  new Properties();
        //3.1通过ClassLoader获取绝对路径
//        ClassLoader cl = Demo01_druid.class.getClassLoader();
//        URL urls = cl.getResource("druid.properties");
//        String path = urls.getPath();
//        ppts.load(new FileReader(path));
        InputStream is = Demo01_druid.class.getClassLoader().getResourceAsStream("druid.properties");
        ppts.load(is);
        //4.获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(ppts);
        //5.链接
        Connection coon = dataSource.getConnection();

    }
}
