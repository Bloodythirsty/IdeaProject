package lesson01;

import domain.Emp;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author zkk;
 * @create 2019-11-28;
 */
public class Demo05_exerice {

    /**
     * 查询所有emp表中数据
     * @return
     */
    public static void main(String[] args) {
        List<Emp> list = new Demo05_exerice().findAll();
        for (Emp emp : list) {
            System.out.println("emp = " + emp);
        }
    }

    public List<Emp> findAll(){
        Connection conn = null;
        Statement stmt = null;
        List<Emp> list = new ArrayList<Emp>();
        try {
            //1.注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2.链接对象
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exercise  ?useSSL=false&serverTimezone=GMT","root","123456");
            //3.执行对象
            stmt = conn.createStatement();
            //4.sql
            String sql = "select * from emp WHERE mgr = 1006";
            //5.执行
            ResultSet rs = stmt.executeQuery(sql);
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
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }


        }
        return list;
    }
}
