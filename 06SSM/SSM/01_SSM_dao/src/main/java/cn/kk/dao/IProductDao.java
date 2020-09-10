package cn.kk.dao;

import cn.kk.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductDao {

    //  查询所有
    @Select("select * from product")
    public List<Product> findAll() throws Exception;

    //查询一个
    @Select("select * from product where id = #{id}")
    public Product findById(String id) throws Exception;

    @Insert("insert into product(id,productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus)" +
            " values(#{id},#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    public void saveOne(Product product) throws Exception;
}
