package kk;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zkk;
 * @create 2020-04-02;
 */
public class User {
    private String name;
    private String gender;
    private Date bir;

    /**
     * 逻辑视图：并没有birStr成员变量，是为了完成页面显示
     * @return
     */
    public String getBirStr(){
        if (this.bir != null){
            return new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss").format(this.bir);
        }
        return null;
    }
    public Date getBir() {
        return bir;
    }

    public void setBir(Date bir) {
        this.bir = bir;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    //方便jstl/exercise 插入数据
    public User(String name, String gender, Date bir) {
        this.name = name;
        this.gender = gender;
        this.bir = bir;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", bir=" + bir +
                '}';
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
