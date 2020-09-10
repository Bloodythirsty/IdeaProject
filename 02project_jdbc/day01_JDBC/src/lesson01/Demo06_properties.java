package lesson01;

import domain.Emp;
import utils.JDBCutils;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author zkk;
 * @create 2019-11-29;
 */
public class Demo06_properties {
    public static void main(String[] args) {
        List<Emp> list = new Demo06_properties().findAll();
        for (Emp emp : list) {
            System.out.println("emp = " + emp);
        }
    }

    public List<Emp> findAll(){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        List<Emp> list = new ArrayList<Emp>();
        try {
            conn = JDBCutils.getConnection();
            stmt = conn.createStatement();
            //4.sql
            String sql = "select * from emp WHERE mgr = 1006";
            //5.执行
            rs = stmt.executeQuery(sql);
            //6.遍历结果集，封装对象，装载集合
            Emp emp = null;
            while (rs.next()){
                int id = rs.getInt("id");
                String ename = rs.getString("ename");
                int job_id = rs.getInt("job_id");
                int mgr = rs.getInt("mgr");
                Date joindate = rs.getDate("joindate");
                double salary = rs.getDouble("salary");
                double bonus = rs.getDouble("bonus");
                int dept_id = rs.getInt("dept_id");

                //创建emp
                emp = new Emp();
                emp.setId(id);
                emp.setEname(ename);
                emp.setJob_id(job_id);
                emp.setMgr(mgr);
                emp.setJoindate(joindate);
                emp.setSalary(salary);
                emp.setBonus(bonus);
                emp.setDept_id(dept_id);

                list.add(emp);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCutils.close(conn,stmt,rs);
        }
        return list;
    }
}
