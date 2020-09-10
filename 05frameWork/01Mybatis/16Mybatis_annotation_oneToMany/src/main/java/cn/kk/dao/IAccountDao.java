package cn.kk.dao;

import cn.kk.domain.Account;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface IAccountDao {

    /*
            查询所有账户，并且获取账户所属的用户信息(多对一，一对一)
     */
    @Select("select * from account")
    @Results(id = "accountMap",value = {
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "uid",column = "uid"),
            @Result(property = "money",column = "money"),
            @Result(property = "user",column = "id",
                one = @One(select="cn.kk.dao.IUserDao.findOneById",fetchType = FetchType.EAGER)  //一对一查询，立即加载
            )
    })
    List<Account> findAll();

    /*
            根据uid查询account，辅助一对多查询（一个user多个account）
     */

    @Select("select * from account where uid = #{uid}")
    List<Account> findAccountsByUid(int uid);

}
