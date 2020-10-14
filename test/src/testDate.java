import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.*;

public class testDate {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //设置为东八区
        sdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        Date newDate = new Date();
        String dateStr = sdf.format(newDate);
        System.out.println("dateStr = " + dateStr);

        Map<Object, Object> objectObjectHashMap = new HashMap<>();

    }

    @Test
    public void testEqual(){
        String s1 = "aaa";
        String s2 = "aa"+new String("a");
        String s3 = new String("aaa");

        System.out.println(s1==s2);
        System.out.println(s1==s3);
        System.out.println(s2==s3);

        System.out.println("s1.equals(s2) = " + s1.equals(s2));
        System.out.println("s1.equals(s3) = " + s1.equals(s3));
        System.out.println("s2.equals(s2) = " + s2.equals(s3));

        System.out.println("s1.intern().equals(s2) = " + s1.intern().equals(s2));
        System.out.println("s1.intern().equals(s3) = " + s1.intern().equals(s3));
        System.out.println("s2.intern().equals(s3) = " + s2.intern().equals(s3));

        System.out.println("s1.intern() == s2 = " + s1.intern() == s2);
        System.out.println("s1.intern() == s3 = " + s1.intern() == s3);
        System.out.println("s2.intern() == s3 = " + s2.intern() == s3);

        System.out.println(" StringBuilder------------------ " );

        String s = new StringBuilder("ja").append("va").toString();
        System.out.println("s.intern() == s = " + s.intern() == s);
        System.out.println("s.equals(s.intern()) = " + s.equals(s.intern()));


        String s4 = new StringBuilder("计算机").append("ruanjian").toString();
        System.out.println("s4.intern() == s4 = " + s4.intern() == s4);

    }
}
