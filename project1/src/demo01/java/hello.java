package demo01.java;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zkk;
 * @create 2019-11-26;
 */
public class hello {
    public static void main(String[] args) {
        String format = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        System.out.println("format = " + format);
    }
}
