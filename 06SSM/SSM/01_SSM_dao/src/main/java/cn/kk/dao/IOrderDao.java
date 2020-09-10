package cn.kk.dao;

import cn.kk.domain.Member;
import cn.kk.domain.Orders;
import cn.kk.domain.Product;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IOrderDao {
    @Select("select * from orders")
    @Results(value = {
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderStatus",column = "orderStatus"),
            //@Result(property = "productId",column = "memberId"),      不需要外键
            //@Result(property = "productId",column = "productId"),
            @Result(property = "product",column = "productId",
                javaType = Product.class,one = @One(select = "cn.kk.dao.IProductDao.findById",fetchType = FetchType.EAGER))
    })
    public List<Orders> findAll() throws Exception;

    @Select("select * from orders where id = #{ordersId}")
    @Results(value = {
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "product",column = "productId",      //根据查出来的表中的productId查询
                    javaType = Product.class,one = @One(select = "cn.kk.dao.IProductDao.findById",fetchType = FetchType.EAGER)),
            @Result(property = "member",column = "memberId",        //根据查出来的表中的memberId查询
                    javaType = Member.class,one = @One(select = "cn.kk.dao.IMemberDao.findById",fetchType = FetchType.EAGER)),
            @Result(property = "travellers",column = "id",
                    javaType = java.util.List.class,many = @Many(select = "cn.kk.dao.ITravellerDao.findListByOrderId",fetchType = FetchType.LAZY))
    })
    public Orders findById(String ordersId) throws Exception;

}
