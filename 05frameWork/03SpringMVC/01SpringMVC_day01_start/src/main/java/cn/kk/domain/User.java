package cn.kk.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class User implements Serializable {

    private String username;
    private String password;
    private Double money;

    private Account account;

    private List<Account> listAccount;
    private Map<String,Account> mapAccount;

    public Map<String, Account> getMapAccount() {
        return mapAccount;
    }

    public void setMapAccount(Map<String, Account> mapAccount) {
        this.mapAccount = mapAccount;
    }

    public List<Account> getListAccount() {
        return listAccount;
    }

    public void setListAccount(List<Account> listAccount) {
        this.listAccount = listAccount;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", money=" + money +
                ", account=" + account +
                ", listAccount=" + listAccount +
                ", mapAccount=" + mapAccount +
                '}';
    }
}
