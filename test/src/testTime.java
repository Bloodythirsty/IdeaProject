import java.util.Date;

public class testTime {

    public static void main(String[] args) {
        Date date = new Date();
        System.out.println("date.toString() = " + date.toString());
        for (int i = 0; i < 1000000; i++) {

        }
        long time = new Date().getTime() - date.getTime();

        System.out.println("time = " + time);

    }
}
