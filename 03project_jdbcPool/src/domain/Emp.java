package domain;

import javax.xml.crypto.Data;
import java.util.Date;

/**
 * @author zkk;
 * @create 2019-12-09;
 */
public class Emp {
//    private int id;       //test6_1()用
//    private String name;
//    private String gender;
//    private double salary;
//    private Date join_date;
//    private int dept_id;



//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public void setGender(String gender) {
//        this.gender = gender;
//    }
//
//    public void setSalary(double salary) {
//        this.salary = salary;
//    }
//
//    public void setJoin_date(Date join_date) {
//        this.join_date = join_date;
//    }
//
//    public void setDept_id(int dept_id) {
//        this.dept_id = dept_id;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public String getGender() {
//        return gender;
//    }
//
//    public double getSalary() {
//        return salary;
//    }
//
//    public Date getJoin_date() {
//        return join_date;
//    }
//
//    public int getDept_id() {
//        return dept_id;
//    }

    private Integer id;       //test6_3()用,直接将基本数据类型为封装,这样double可以用null
    private String name;
    private String gender;
    private Double salary;
    private Date join_date;
    private Integer dept_id;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public Double getSalary() {
        return salary;
    }

    public Date getJoin_date() {
        return join_date;
    }

    public Integer getDept_id() {
        return dept_id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public void setJoin_date(Date join_date) {
        this.join_date = join_date;
    }

    public void setDept_id(Integer dept_id) {
        this.dept_id = dept_id;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", salary=" + salary +
                ", join_date=" + join_date +
                ", dept_id=" + dept_id +
                '}';
    }


}
