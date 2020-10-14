package serializable;

import java.io.Serializable;

public class Student implements Serializable {


    private static final long serialVersionUID = 771652260758459933L;

    private String name;
    private Integer age;
    private String sex;

    // private String addr;
    //
    // public String getAddr() {
    //     return addr;
    // }
    //
    // public void setAddr(String addr) {
    //     this.addr = addr;
    // }



    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
