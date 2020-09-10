package cn.kk.dao;

import cn.kk.domain.Items;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository("itemsDao")
public interface IItemsDao {

    @Select("select * from items where id = #{id}")
    public Items findById(Integer id);


    @Update("update items set price = #{price} where id = #{id}")
    public void update(Items items);

}
