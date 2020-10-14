package cn.kk.utils;

import java.util.UUID;

public final class UUIDutils {
    public static String getUpperUUID(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString().replace("-", "").toUpperCase();
    }
    public static String getLowerUUID(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString().replace("-", "").toLowerCase();
    }
}
