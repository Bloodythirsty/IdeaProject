package pack.config;

import java.math.BigInteger;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import pack.utils.SolutionEncodeDecodeUtils;

/**
 * Description: spring配置
 *
 * @Author: zhang kangkang
 * @DateTime: 2022-01-20 7:48 PM
 */
@Configuration
@MapperScan(basePackages = "_2020/tencent/sunflower/admin/dao/mapper")
@PropertySource({"classpath:application-db.properties"})
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class SpringConfig {



    public static void main(String[] args) {
        SolutionEncodeDecodeUtils.decode("66mQR6lBHMV6");
    }


}
