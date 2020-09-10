package cn.kk.dao;

import cn.kk.domain.Account;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("accountDao")
public interface IAccountDao {

    @Select("select * from account")
    @Results(id = "userMap",value = {
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "name",column = "name"),
            @Result(property = "money",column = "money")
    })
    public List<Account> findAll();

    @Select("select * from account where id = #{id}")
    public Account findById(Integer id);

    // mybatis不需要这样写 ：account.name
    @Insert("insert into account(name,money) values(#{name},#{money}) ")
    public void saveAccount(Account account);

    @Update("update account set money = #{money} where id = #{id}")
    public void update(Account account);
}
