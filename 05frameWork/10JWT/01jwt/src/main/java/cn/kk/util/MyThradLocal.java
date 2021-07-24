package cn.kk.util;

public class MyThradLocal {
    public static final ThreadLocal<String> TL = new ThreadLocal<>();


    public static String getTokenFromThreadLocal(){
        return TL.get();
    }

    public static void setTokenFromThreadLocal(String username){
        TL.set(username);
    }

    public static void removeTokenFromThreadLocal(){
        TL.remove();
    }

}
