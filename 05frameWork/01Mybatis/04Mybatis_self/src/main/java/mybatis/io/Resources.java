package mybatis.io;

import java.io.InputStream;

/**
 *  1. 使用类加载器读取配置文件
 */
public class Resources {

    public static InputStream getResourceAsStream(String filePath){
        return Resources.class.getClassLoader().getResourceAsStream(filePath);
    }
}
