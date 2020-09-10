package jdbcTemplate;

import domain.Emp;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import utils.JDBCutils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author zkk;
 * @create 2019-12-09;
 */
public class Demo02_use {
    /*
    Junit单元测试，可以让方法独立执行，不依赖于main
    加注解：@Test,然后提示：加入到路径即可
     */

    @Test
    public void test1(){  // 需求：修改db3，emp中，1号salary为10000
        //1.创建JdbcTemplate对象
        JdbcTemplate jt = new JdbcTemplate(JDBCutils.getDataSource());
        //2.执行( 需求：修改db3，emp中，1号salary为10000),修改druid.properties里面的database
        String sql = "UPDATE emp SET salary = ? WHERE id = ?";
        int account = jt.update(sql, 9999, 1);
    }

    @Test
    public void test2(){    //添加一条记录
        JdbcTemplate jt = new JdbcTemplate(JDBCutils.getDataSource());
        String sql = "INSERT INTO emp VALUES(null,?,?,?,?,?)";
        jt.update(sql,"张康康","男",10000000,"2019-11-11",1);

    }

    @Test
    public void test3(){    //删除刚才添加的记录
        JdbcTemplate jt = new JdbcTemplate(JDBCutils.getDataSource());
        String sql = "DELETE FROM emp WHERE id = ?";
        jt.update(sql,7);
    }

    @Test
    public void test4(){    //查询id=1记录，封装为map集合
        JdbcTemplate jt = new JdbcTemplate(JDBCutils.getDataSource());
        String sql = "SELECT * FROM emp WHERE id = ?";
        Map map = jt.queryForMap(sql,1);
        System.out.println(map);
        for (Object o : map.keySet()) {
            System.out.println("key: "+ o + " -- value: " + map.get(o));
        }
    }

    @Test
    public void test5(){ //查询所有记录，封装为List
        JdbcTemplate jt = new JdbcTemplate(JDBCutils.getDataSource());
        String sql = "SELECT * FROM emp";
        List<Map<String, Object>> maps = jt.queryForList(sql);
        for (Map<String, Object> map : maps) {
            System.out.println(map);
            for(Object o : map.keySet()){ System.out.println("key: "+ o + " -- value: " + map.get(o));
            }
        }
    }

 //   @Test
//    public void test6_1(){    //(自己写的)查询所有记录，将其封装为Emp对象List集合
//        JdbcTemplate jt = new JdbcTemplate(JDBCutils.getDataSource());
//        String sql = "SELECT * FROM emp";
//        List<Emp> listEmps = new ArrayList<>();
//        List<Map<String, Object>> maps = jt.queryForList(sql);
//        for (Map<String, Object> map : maps) {
//            Emp emp = new Emp();
//            int i = 0;
//            for(String o : map.keySet()){
//                switch (i){
//                    case 0:
//                        emp.setId(Integer.parseInt(String.valueOf(map.get(o))));    //自动编号，不会出现null
//                        break;
//                    case 1:
//                        emp.setName((String)map.get(o));
//                        break;
//                    case 2:
//                        emp.setGender((String)map.get(o));
//                    break;
//                    case 3:
//                        if(map.get(o) == null){     //salary可能为null
//                            emp.setSalary(0);
//                        }else {
//                            emp.setSalary(Double.parseDouble(String.valueOf(map.get(o))));
//                        }
//                        break;
//                    case 4:
//                        emp.setJoin_date((Date)map.get(o));
//                        break;
//                    case 5:
//                        if (map.get(o) == null){
//                            emp.setDept_id(0);
//                        }else{
//                            emp.setDept_id(Integer.parseInt(String.valueOf(map.get(o))));
//                        }
//                        break;
//                    case 6:
//                        break;
//                    default:
//                        throw new IllegalStateException("Unexpected value: " + i);
//                }
//                i++;
//            }
//            listEmps.add(emp);
//        }
//        System.out.println(listEmps);
//    }

    @Test
    public void test6_2(){    //查询所有记录，将其封装为Emp对象List集合
        JdbcTemplate jt = new JdbcTemplate(JDBCutils.getDataSource());
        String sql = "SELECT * FROM emp";
        List<Emp> list = jt.query(sql, new RowMapper<Emp>() {
            //一条一条查，查一条后返回一个结果集
            @Override
            public Emp mapRow(ResultSet rs, int i) throws SQLException {

                Emp emp = new Emp();

                 int id = rs.getInt("id");
                 String name = rs.getString("name");
                 String gender = rs.getString("gender");
                 double salary = rs.getDouble("salary");
                 Date join_date = rs.getDate("join_date");
                 int dept_id = rs.getInt("dept_id");

                emp.setId(id);
                emp.setName(name);
                emp.setGender(gender);
                emp.setSalary(salary);
                emp.setJoin_date(join_date);
                emp.setDept_id(dept_id);

                return emp;
            }
        });

        for (Emp emp : list) {
            System.out.println("emp = " + emp);
        }
    }



    @Test
    public void test6_3(){    //查询所有记录，将其封装为Emp对象List集合
        JdbcTemplate jt = new JdbcTemplate(JDBCutils.getDataSource());
        String sql = "SELECT * FROM emp";
        List<Emp> list = jt.query(sql,new BeanPropertyRowMapper<Emp>(Emp.class));
        for (Emp emp : list) {
            System.out.println("emp = " + emp);
        }
    }

    @Test
    public void test7(){    //查询总记录数
        JdbcTemplate jt = new JdbcTemplate(JDBCutils.getDataSource());
        String sql = "SELECT COUNT(id) FROM emp";
        Long total = jt.queryForObject(sql,Long.class);
        System.out.println("total = " + total);
    }
}
