package service.imp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dao.ProvinceDao;
import dao.imp.ProvinceDaoImp;
import domain.Province;
import jdcbUtils.JdbcUtils;
import jedis.utils.JedisPoolUtil;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import redis.clients.jedis.Jedis;
import service.ProvinceService;

import java.util.List;

public class ProvinceServiceImp implements ProvinceService {

    //1. 声明dao
    private ProvinceDao dao ;
    //2. 添加ObjectMapper,用于序列化json
    private ObjectMapper mapper ;

    public ProvinceServiceImp() {
        this.dao = new ProvinceDaoImp();
        this.mapper = new ObjectMapper();
    }

    @Override
    public List<Province> findAll() {
        return dao.findAll();
    }

    //优化
    @Override
    public String findAllRedis() throws JsonProcessingException {
        //使用redis缓存查询
        //1. 获取客户端链接
        Jedis jedis = JedisPoolUtil.getJedis();
        //2. 查
        String provinces = jedis.get("province");
        //3. 判断是否为空,为空查询后加入redis
        if (provinces == null || provinces.length() == 0){
            System.out.println("redis无数据");
            List<Province> list = findAll();
            provinces = mapper.writeValueAsString(list);
            //放入redis
            jedis.set("province",provinces);
            jedis.close();
        }else{
            System.out.println("redis有数据");
        }
        return provinces;
    }
}
