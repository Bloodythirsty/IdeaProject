package pack.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.joda.time.DateTime;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author zhangkangkang created on 2021/2/5 3:43 下午
 */
@Component
public class DateUtils {
    public static String getNowDateFormatCustom(String pattern){
        return new DateTime().toString(pattern);
    }

    @Async
    public void testAsync(){
        try {
            Thread.sleep(1000);
            System.out.println(" Async = " );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    /**
     * 随机生成六位数 （000001-999999）
     */
    public static String MakeSixNums() {
        Integer randNum = (int) (Math.random() * (999999) + 1);//产生(0,999999]之间的随机数
        String workPassWord = String.format("%06d", randNum);//进行六位数补全
        return workPassWord;
    }

    public static  String getTimeStamp(){
        long millis = DateTime.now().getMillis();
        return String.valueOf(millis / 1000);
    }

    public static String formatDate(Date date, String format) {
        if (date == null) {
            return "";
        }
        try {
            SimpleDateFormat formatter = new SimpleDateFormat(format);
            String ret = formatter.format(date);
            return ret;
        } catch (Exception e) {
            return "";
        }
    }

    public static String format6 = "yyyyMMddHHmmss";


    public static String getFileDateFormat() {
        return formatDate(DateTime.now().toDate(), format6);
    }

    public static void main(String[] args) {
        String fileDateFormat = DateUtils.getFileDateFormat();
        System.out.println("fileDateFormat = " + fileDateFormat);
    }
}
