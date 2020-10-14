package jedis.test;

import jedis.utils.JedisPoolUtil;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
Jedis的测试类
 */
public class JedisTest {
    /*
    快速入门
     */
    @Test
    public void test1(){
        //1. 获取链接
        Jedis jedis = new Jedis("47.94.209.35",6379);
        jedis.auth("123456");
        //2. 操作
        jedis.set("password","123");
        //3. 关闭资源
        jedis.close();
    }

    /*
    String 类型
     */
    @Test
    public void test2(){
        //1. 获取链接
        Jedis jedis = new Jedis(); //空参，默认值："localhost",6379
        //2. 操作
        jedis.set("name","张康康");
        String name = jedis.get("name");
        System.out.println("name = " + name);
        jedis.del("username");

        //setex() 指定几秒后自动删除, 激活邮件！
        jedis.setex("gender", 5, "mail");

        //System.out.println(jedis.get("province"));
        String a = "";
        String b = null;
        System.out.println("" == null);
        System.out.println("".equals(null));
        System.out.println(a.equals(null));
        System.out.println(a.equals(""));
//        System.out.println(b.equals(null));
//        System.out.println(b.equals(""));       //null不能先比较，否则空指针异常
        System.out.println(b == null);

        //3. 关闭资源
        jedis.close();
    }
    /*
   hash 类型
    */
    @Test
    public void test3(){
        //1. 获取链接
        Jedis jedis = new Jedis(); //空参，默认值："localhost",6379
        //2. 操作
        jedis.hset("student","name","lisi");
        jedis.hset("student","age","23");
        jedis.hset("student","gender","male");

        String name = jedis.hget("student", "name");
        System.out.println("name = " + name);
        Map<String, String> studentMap = jedis.hgetAll("student");
        Set<String> set = studentMap.keySet();
        for (String field: set
             ) {
            System.out.println(field + ":" + jedis.hget("student",field));
        }

        //3. 关闭资源
        jedis.close();
    }

    /*
   list 类型
    */
    @Test
    public void test4(){
        //1. 获取链接
        Jedis jedis = new Jedis(); //空参，默认值："localhost",6379
        //2. 操作
        jedis.lpush("mylist","a","b","c");
        jedis.rpush("mylist","a","b","c");

        List<String> mylist = jedis.lrange("mylist", 0, -1);
        System.out.println("mylist = " + mylist);

        String element = jedis.lpop("mylist");
        System.out.println("element = " + element);
        String element1 = jedis.rpop("mylist");
        System.out.println("element1 = " + element1);

        List<String> mylist1 = jedis.lrange("mylist", 0, -1);
        System.out.println("mylist1 = " + mylist1);
        //3. 关闭资源
        jedis.close();
    }

    /*
   set/sortedset 类型
    */
    @Test
    public void test5(){
        //1. 获取链接
        Jedis jedis = new Jedis(); //空参，默认值："localhost",6379
        //2. 操作
        //添加
        jedis.sadd("myset","java","c++","php");

        Set<String> myset = jedis.smembers("myset");
        System.out.println("myset = " + myset);

        //删除
        Long srem = jedis.srem("myset", "php");
        System.out.println("srem = " + srem);

        Set<String> myset1 = jedis.smembers("myset");
        System.out.println("myset1 = " + myset1);

        //弹出
        String spop = jedis.spop("myset");
        System.out.println("spop = " + spop);

        Set<String> myset2 = jedis.smembers("myset");
        System.out.println("myset2 = " + myset2);

        //3. 关闭资源
        jedis.close();
    }

    /*
   set/sortedset 类型
    */
    @Test
    public void test6(){
        //1. 获取链接
        Jedis jedis = new Jedis(); //空参，默认值："localhost",6379
        //2. 操作
        //添加
        jedis.zadd("mysortedset",2,"女警");
        jedis.zadd("mysortedset",100,"压缩");
        jedis.zadd("mysortedset",30,"诺手");
        jedis.zadd("mysortedset",30,"哈哈");
        jedis.zadd("mysortedset",30,"阿门");
        jedis.zadd("mysortedset",2000,"阿门");        //会覆盖前面的

        Set<String> mysortedset = jedis.zrange("mysortedset", 0, -1);
        System.out.println("mysortedset = " + mysortedset);

        //3. 关闭资源
        jedis.close();
    }

    /**
     * 测试JedisPool
     */
    @Test
    public void test7(){

        //0 创建一个配置对象
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(50);       //最大允许连接数
        config.setMaxIdle(10);        //最大空闲链接

        //1. 创建连接池
        JedisPool jedisPool = new JedisPool(config,"localhost",6379);
        //2. 获取链接
        Jedis jedis = jedisPool.getResource();
        //3. 操作
        jedis.set("jedisPool","haha");
        //4. 关闭，归还
        jedis.close();
    }

    /**
     * 测试JedisPoolUtil
     */
    @Test
    public void test8(){
        //获取链接
        Jedis j = JedisPoolUtil.getJedis();
        //操作
        j.set("JedisPoolUtil","JedisPoolUtil");
        j.set("JedisPoolUtil_1","JedisPoolUtil_1");
        //关闭
        JedisPoolUtil.closeJedis(j);
    }

    @Test
    public void test9(){
        InputStream resourceAsStream = JedisTest.class.getClassLoader().getResourceAsStream("jedis.properties");
        System.out.println("resourceAsStream = " + resourceAsStream);
    }

}
