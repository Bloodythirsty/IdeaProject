package kk;

/**
 * @author zkk;
 * @create 2020-03-25;
 *
 * 用户的实体类
 */
public class User {
    private int id;
    private String username;
    private String password;
    private String gender;      //测试BeanUtils

    public void setHaha(String gender){     //测试BeanUtils
        this.gender = gender;
    }
    public String getHaha(){
        return gender;
    }

    public User(){

    }

    public User(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
