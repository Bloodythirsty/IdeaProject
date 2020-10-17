package cn.kk.utils;

import cn.kk.domain.Users;

public class UserThreadLocal {
    //一般定义为 static final，不断掉强引用，不然内存泄漏
    private static final ThreadLocal<Users> TL = new ThreadLocal<>();

    public static void setUserSession(Users users){
        TL.set(users);
    }

    public static Users getUserSession(){
        return TL.get();
    }

    //用完一定要remove，不然内存泄漏，切记
    public static void removeUserSession(){
        TL.remove();
    }
}
