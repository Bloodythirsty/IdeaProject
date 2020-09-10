package dao.imp;

import dao.ProvinceDao;
import domain.Province;
import jdcbUtils.JdbcUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ProvinceDaoImp implements ProvinceDao {

    //1. 使用JdbcTemplate
    private JdbcTemplate template = new JdbcTemplate(JdbcUtils.getDataSource());

    @Override
    public List<Province> findAll() {
        //2. 定义SQL
        String sql = "select * from province";
        //3. 查询
        List<Province> list = template.query(sql, new BeanPropertyRowMapper<Province>(Province.class));

        return list;
    }
}
