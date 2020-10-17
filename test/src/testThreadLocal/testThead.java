package testThreadLocal;

import java.util.concurrent.ThreadPoolExecutor;

public class testThead {
    public static void main(String[] args) {
        Thread thread = new Thread(new myTask());
        thread.setName("111");
        Thread thread1 = new Thread(new myTask());
        thread1.setName("222");
        thread.start();
        thread1.start();
    }

}
class myTask implements Runnable{

    @Override
    public void run() {
        for (int i = 0 ; i < 100; i++){
            try {
                Thread.sleep(10);
                System.out.println(Thread.currentThread().getName()+"i = " + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}

