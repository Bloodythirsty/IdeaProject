import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = simpleDateFormat.parse("2000-11-11");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("date = " + date);

        System.out.println("-----------------------------");
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat1.format(date1);
        System.out.println("format = " + format);

        Date parseDate = simpleDateFormat1.parse(format);
        System.out.println("parseDate = " + parseDate);

    }
}
