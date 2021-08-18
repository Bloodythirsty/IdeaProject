import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestThreadLocalSDF {

    static ThreadLocal<DateFormat> sdf = ThreadLocal.withInitial(()->
        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    );

    public static void main(String[] args) {
        String dateStr = "1111-11-11 11:11:11";
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 10000; i++) {
            executorService.submit(()->{
                try {
                    System.out.println(sdf.get().format(sdf.get().parse(dateStr))+"---"+Thread.currentThread().getName()    );
                } catch (ParseException e) {
                    e.printStackTrace();
                }finally {
                    sdf.remove();
                }
            });
        }
    }

    public static void testSimpleDataFormate(){
        /*
        1111-11-11 11:11:11---pool-1-thread-39
        1203-07-11 11:11:11---pool-1-thread-28

        多线程不安全，结果如上
        因为SDF里面的calendar是共享变量
        每次调用parse方法，都会用例calendar新建一个date类
        新建的过程中，对calendar的操作分为 clear和设置属性
        这个时候多线程操作就会发生问题

         */
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = "1111-11-11 11:11:11";
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 50; i++) {
            executorService.submit(() -> {
                try {
                    System.out.println(sdf.format(sdf.parse(dateStr))+"---"+Thread.currentThread().getName()    );
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            });
        }
        executorService.shutdown();
    }
}
