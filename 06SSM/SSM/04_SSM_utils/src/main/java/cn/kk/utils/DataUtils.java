package cn.kk.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DataUtils {

    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String DataToString(Date date){
        dateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        return dateFormat.format(date);
    }

    public static Date StringToData(String dataStr)  {
        try {
            dateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
            return  dateFormat.parse(dataStr);
        } catch (ParseException e) {
            throw new RuntimeException("StringToDataException");
        }
    }
}
