import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class testDate {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //设置为东八区
        sdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        Date newDate = new Date();
        String dateStr = sdf.format(newDate);
        System.out.println("dateStr = " + dateStr);
    }
}
