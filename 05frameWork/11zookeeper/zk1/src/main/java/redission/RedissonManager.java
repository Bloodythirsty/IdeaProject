package redission;

import org.redisson.Redisson;
import org.redisson.config.Config;

public class RedissonManager {
    private static Config config = new Config();
    //声明redisso对象
    private static Redisson redisson = null;
    //实例化redisson
    static{
        config.useSingleServer().setAddress("http://49.234.56.194:6380");
        config.setLockWatchdogTimeout(15*1000);
        //得到redisson对象
        redisson = (Redisson) Redisson.create(config);

    }

    //获取redisson对象的方法
    public static Redisson getRedisson(){
        return redisson;
    }
}
