package cn.kk.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class User implements Serializable {
    // private int id;
    // private String username;
    // private String sex;
    // private String address;
    // private Date birthday;
    //
    // public int getId() {
    //     return id;
    // }
    //
    // public void setId(int id) {
    //     this.id = id;
    // }
    //
    // public String getUsername() {
    //     return username;
    // }
    //
    // public void setUsername(String username) {
    //     this.username = username;
    // }
    //
    // public String getSex() {
    //     return sex;
    // }
    //
    // public void setSex(String sex) {
    //     this.sex = sex;
    // }
    //
    // public String getAddress() {
    //     return address;
    // }
    //
    // public void setAddress(String address) {
    //     this.address = address;
    // }
    //
    // public Date getBirthday() {
    //     return birthday;
    // }
    //
    // public void setBirthday(Date birthday) {
    //     this.birthday = birthday;
    // }
    //
    // @Override
    // public String toString() {
    //     return "User{" +
    //             "id=" + id +
    //             ", username='" + username + '\'' +
    //             ", sex='" + sex + '\'' +
    //             ", address='" + address + '\'' +
    //             ", birthday=" + birthday +
    //             '}';
    // }

    private int userId;
    private String userUsername;
    private String userSex;
    private String userAddress;
    private Date userBirthday;

    // 一对多查询（一个用户对应多个账户）
    private List<Account> accounts;

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userUsername='" + userUsername + '\'' +
                ", userSex='" + userSex + '\'' +
                ", userAddress='" + userAddress + '\'' +
                ", userBirthday=" + userBirthday +
                '}';
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserUsername() {
        return userUsername;
    }

    public void setUserUsername(String userUsername) {
        this.userUsername = userUsername;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public Date getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(Date userBirthday) {
        this.userBirthday = userBirthday;
    }
}
