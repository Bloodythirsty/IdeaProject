package cn.kk.service.impl;

import cn.kk.service.IAccountService;

import java.util.*;

public class AccountServiceImpl3 implements IAccountService {

    // 复杂类型
    private String[] mystrs;
    private List<String> mylist;
    private Set<String> myset;
    private Map<String,String> mymap;
    private Properties myproperties;

    public void setMystrs(String[] mystrs) {
        this.mystrs = mystrs;
    }

    public void setMylist(List<String> mylist) {
        this.mylist = mylist;
    }

    public void setMuset(Set<String> muset) {
        this.myset = muset;
    }

    public void setMymap(Map<String, String> mymap) {
        this.mymap = mymap;
    }

    public void setMyproperties(Properties myproperties) {
        this.myproperties = myproperties;
    }

    public void saveAccount() {
        System.out.println(Arrays.toString(mystrs));
        System.out.println(mylist);
        System.out.println(myset);
        System.out.println(mymap);
        System.out.println(myproperties);
    }
}
