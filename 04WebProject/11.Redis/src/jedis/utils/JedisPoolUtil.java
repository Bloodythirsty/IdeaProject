package jedis.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/*
jedis工具类：
    读取配置文件
    提供获取链接的方法
 */
public class JedisPoolUtil {

    private static JedisPool jedisPool;

    static{
        //1. 创建properties，并关联
        InputStream is = JedisPoolUtil.class.getClassLoader().getResourceAsStream("jedis.properties");
        Properties properties = new Properties();
        try {
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //2. 获取数据，设置Config
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(Integer.parseInt(properties.getProperty("maxTotal")));
        config.setMaxIdle(Integer.parseInt(properties.getProperty("maxIdle")));

        //3. 初始化pool
        jedisPool = new JedisPool(config,
                properties.getProperty("host"),
                Integer.parseInt(properties.getProperty("port")));
    }

    /**
     * 获取连接方法
     */
    public static Jedis getJedis(){
        return jedisPool.getResource();
    }

    public static void closeJedis(Jedis jedis){
        jedis.close();
    }

}
