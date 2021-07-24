package redission;


public class Test1 {

    static String lock = "1";
    public static void main(String[] args) throws InterruptedException {


        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                public void run() {
                    try {
                        RedissonLock.acquire(lock);
                        Thread.sleep(20*1000);
                        RedissonLock.release(lock);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
