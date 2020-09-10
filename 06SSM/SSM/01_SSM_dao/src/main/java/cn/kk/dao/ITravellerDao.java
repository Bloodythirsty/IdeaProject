package cn.kk.dao;

import cn.kk.domain.Traveller;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface ITravellerDao {

    /*
            这样可以，但数据多了效率慢，子查询，数据库会建立副表
     */
  //  @Select("select * from traveller where id in (select travellerId from order_traveller where orderId = #{orderId})")

    /*
            这样mybatis可以自动封装，但id太多了，只能封装第一个，所以容易封装错
     */
    // @Select("SELECT * from " +
    //         "orders o INNER JOIN order_traveller ot ON o.id = ot.orderId" +
    //         " INNER JOIN traveller t ON ot.travellerId = t.id AND o.id = #{orderId}")

    /*
            解决：选出想要的属性即可
     */
    @Select("SELECT t.id,t.name,t.sex,t.phoneNum,t.credentialsType,t.credentialsNum,t.travellerType from " +
            "orders o INNER JOIN order_traveller ot ON o.id = ot.orderId" +
            " INNER JOIN traveller t ON ot.travellerId = t.id AND o.id = #{orderId}")
    public List<Traveller> findListByOrderId(String orderId) throws Exception;

}
