package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.CategoryDao;
import cn.itcast.travel.dao.impl.CategoryDaoImpl;
import cn.itcast.travel.domain.Category;
import cn.itcast.travel.service.CategoryService;
import cn.itcast.travel.util.JedisUtil;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CategoryServiceImpl implements CategoryService {

    CategoryDao categoryDao = new CategoryDaoImpl();

    @Override
    public List<Category> findAllCategory() {
        //1. 从redis中查询
        //1.1 获取jedis客户端
        Jedis jedis = JedisUtil.getJedis();
        //1.2 使用sortedset
        // 直接zrange没有cid
        //Set<String> categorysFromRedis = jedis.zrange("category", 0, -1);
        Set<Tuple> categorysFromRedis = jedis.zrangeWithScores("category", 0, -1);
        //2. 判断是否为null
        List<Category> allCategory = null;
        if (categorysFromRedis == null || categorysFromRedis.size() == 0){
            System.out.println("redis is null");
            //3. 如果为空，查询数据库，放入redis
            //3.1 查询数据库
            allCategory = categoryDao.findAllCategory();
            //3.2 存入redis，遍历存入category集合
            for (int i = 0; i < allCategory.size(); i++) {
                jedis.zadd("category", allCategory.get(i).getCid(),allCategory.get(i).getCname());
            }
        }else {
            //4. 不为null,redis中存在，把set集合转为list
            allCategory = new ArrayList<Category>();
            //for (String name:categorysFromRedis){
            for (Tuple tuple:categorysFromRedis){
                Category category = new Category();
//                category.setCname(name);
                category.setCname(tuple.getElement());
                category.setCid((int) tuple.getScore());
                allCategory.add(category);
            }
        }
        return  allCategory;
    }
}
