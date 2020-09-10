package cn.itcast.travel.dao.impl;

import cn.itcast.travel.dao.CategoryDao;
import cn.itcast.travel.domain.Category;
import cn.itcast.travel.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class CategoryDaoImpl implements CategoryDao {

    JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<Category> findAllCategory() {
        String sql = "select * from tab_category";
        List<Category> query = template.query(sql, new BeanPropertyRowMapper<Category>(Category.class));
        System.out.println("query = " + query);
        return query;
    }
}
