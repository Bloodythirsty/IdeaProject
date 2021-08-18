package pack._2021testspring.utils;

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
}
