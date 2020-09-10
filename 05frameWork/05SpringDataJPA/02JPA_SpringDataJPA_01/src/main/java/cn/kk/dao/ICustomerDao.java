package cn.kk.dao;

import cn.kk.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/*
        不用写内容，即可完成基本CRUD
 */
public interface ICustomerDao extends JpaRepository<Customer,Integer> , JpaSpecificationExecutor<Customer> {
    /*
        使用客户名称查询客户
        jpql: from Customer where name = ?
     */
    @Query(value = "from Customer where name = ?")
    public Customer findByNameJPQL(String name);

    /*
            1. 根据客户名称和客户id查询
                jpql：from Customer where id = ? and name = ?
            2. 默认情况下，展位符的位置与传入的参数顺序相同
            3. 可以指定占位符参数的位置
                1. ？参数索引
     */
    // @Query(value = "from Customer where id = ? and name = ?")
    // public Customer findByIdAndName(Integer id, String name);

    @Query(value = "from Customer where id = ?2 and name = ?1")
    public Customer findByIdAndName(String name, Integer id);

    /*
            使用jpql完成更新：
            jpql：update Customer set name = ? where id = ?
            @Query: 代表的是查询
            所以还要配置@Modifying：代表当前执行是更新操作
     */
    @Query(value = "update Customer set name = ?2 where id = ?1")
    @Modifying
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void updateById(Integer id,String name);


    /*
            sql查询
     */
    @Query(value = "select * from cst_customer ",nativeQuery = true)
    public List<Customer> findAllBySql();

    /*
            根据用户名模糊匹配
     */
    // @Query(value = "select * from cst_customer where cust_name like '%王%' ", nativeQuery = true)
    @Query(value = "select * from cst_customer where cust_name like ? ", nativeQuery = true)
    public List<Customer> findBySqlLike(String name);

    /*
            根据命名规则查询
     */
    public Customer findByName(String name);

    /*
            根据命名规则查询：模糊查询
     */
    public List<Customer> findByNameLike(String like);

    /*
            根据命名规则查询：多条件查询
            sql：select * from cst_customer where cust_name like ? and cust_industry = ?
     */
    public List<Customer> findByNameLikeAndIndustry(String like,String industry);
}
