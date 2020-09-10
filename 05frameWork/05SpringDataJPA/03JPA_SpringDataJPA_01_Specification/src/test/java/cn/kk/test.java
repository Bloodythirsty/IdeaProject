package cn.kk;

import cn.kk.dao.ICustomerDao;
import cn.kk.domain.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.criteria.*;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:ApplicationContext.xml")
public class test {


    @Autowired
    private ICustomerDao customerDao;

    /*
        根据条件，查询单个对象（用对象名查询）

            查询条件：CriteriaBuilder对象里面
            查询属性：Root对象里面
     */
    @Test
    public void test() {
        // 实现接口（匿名内部类）
        Specification<Customer> spec = new Specification<Customer>() {
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                //1. 获取比较的属性(实体里面的属性)
                Path<Object> name = root.get("name");
                //2. 构造查询:(select * from cst_customer where cust_name = ?)
                //第一个参数：比较的属性（path对象）  第二个参数：比较的取值
                Predicate predicate = criteriaBuilder.equal(name, "kkk");//精准匹配
                return predicate;
            }
        };

        Customer one = customerDao.findOne(spec);
        System.out.println("one = " + one);
    }
    /*
            多条件查询：根据客户名和客户行业查询
            sql：select * from cst_customer where cust_name = ? and cust_industry = ?
            1. 构造name的精准查询
            2. 构造所属行业的精准查询
            3. 将以上两个查询联系起来
     */
    @Test
    public void testNameAndIndustry() {
        Specification<Customer> spec = new Specification<Customer>() {
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                //1. 找属性
                Path<Object> name = root.get("name");
                Path<Object> industry = root.get("industry");
                //2. 构造查询
                Predicate namePre = criteriaBuilder.equal(name, "kkk");
                Predicate industryPre = criteriaBuilder.equal(industry, "教育");
                //3. 联系起来，组合（或 or，与 and）
                // criteriaBuilder.or()
                Predicate pre = criteriaBuilder.and(namePre, industryPre);
                return pre;
            }
        };
        Customer one = customerDao.findOne(spec);
        System.out.println("one = " + one);
    }

    /*
            完成模糊查询：
            select * from cst_customer where cust_name like '%?%'
     */

    @Test
    public void testLike() {
        List<Customer> customers = customerDao.findAll(new Specification<Customer>() {
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                //1. 取属性
                Path<Object> name = root.get("name");
                //2. 构造查询
                Predicate pre = criteriaBuilder.like(name.as(String.class), "%王%");
                return pre;
            }
        });
        for (Customer customer : customers) {
            System.out.println("customer = " + customer);
        }
    }

    /*
        排序
     */

    @Test
    public void testSort() {
        Specification<Customer> pre = new Specification<Customer>() {
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Path<Object> name = root.get("name");
                Predicate pre = criteriaBuilder.like(name.as(String.class), "%王%");
                return pre;
            }
        };
        // 1. 创建排序对象
        //1. 第一个参数，顺序   第二个参数：排序的属性
        Sort desc = new Sort(Sort.Direction.DESC, "id");

        List<Customer> customers = customerDao.findAll(pre, desc);
        for (Customer customer : customers) {
            System.out.println("customer = " + customer);
        }
    }

    /*
            分页查询
     */

    @Test
    public void testLimit() {
        Pageable pageable = new PageRequest(0, 4);
        Page<Customer> all = customerDao.findAll(pageable);
        // for (Customer customer : all) {
        //     System.out.println("customer = " + customer);
        // }
        System.out.println(all.getContent());
        System.out.println(all.getTotalElements());
        System.out.println(all.getTotalPages());
    }
}
