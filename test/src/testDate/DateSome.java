package testDate;

import org.junit.Test;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Calendar;
import java.util.Date;

public class DateSome {

    /*
            利用Calendar设置过期时间,并返回date
     */
    @Test
    public void testUtilDate(){
        Calendar instance = Calendar.getInstance();
        System.out.println("instance = " + instance.toString());
        instance.add(Calendar.MINUTE, -60);
        System.out.println("instance = " + instance.toString());
        Date time = instance.getTime();
        System.out.println("time = " + time);
    }

    /*
        1. 因为LocalDate中是不包含时分秒的，想要格式化时分秒需要用LocalDateTime这个类，里边包含的有时分秒
            minus(24, ChronoUnit.HOURS) 会报错
        2. LocalDateTime 一类都是final修饰不可变的，所以minus/plus会构建新的类，使用旧类打印还是没变
     */
    @Test
    public void testLocalDate(){
        LocalDateTime localDateTime1 = LocalDateTime.now();
        System.out.println("localDateTime1 = " + localDateTime1);
        LocalDateTime localDateTime2 = localDateTime1.minus(24, ChronoUnit.HOURS);
        System.out.println("localDateTime2 = " + localDateTime2);

        ZoneId zoneId = ZoneId.systemDefault();
        System.out.println("zoneId = " + zoneId);
        Instant instant1 = localDateTime2.atZone(zoneId).toInstant();
        Date date1 = Date.from(instant1);
        System.out.println("date1 = " + date1);

        //格式化
        //1. 已提供的格式化
        String format = localDateTime2.format(DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println("format = " + format);
        String format1 = localDateTime2.format(DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println("format1 = " + format1);
        String format2 = localDateTime2.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        System.out.println("format2 = " + format2);
        String format3 = localDateTime2.format(DateTimeFormatter.ISO_LOCAL_TIME);
        System.out.println("format3 = " + format3);
        // String format4 = localDateTime2.format(DateTimeFormatter.ISO_OFFSET_DATE);
        // System.out.println("format4 = " + format4);

        //2. 自定义
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String format5 = localDateTime2.format(pattern);
        System.out.println("format5 = " + format5);


    }
}
