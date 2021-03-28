package testWait;

/*
        使用interrupt打破阻塞
        阻塞：
            1. sleep
            2. wait
            3. IO阻塞
 */
public class testInterrupt {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("sleep");
                try {
                    Thread.sleep(5000);
                    System.out.println("sleep done");
                } catch (InterruptedException e) {
                    System.out.println("interrupt!");
                }
            }
        });

        t1.start();
        Thread.sleep(1000);
        System.out.println(t1.isInterrupted()); //false 说明还在阻塞
        t1.interrupt();
        System.out.println(t1.isInterrupted()); //true，没有阻塞
    }
}

public class Test{
    public static void main(String[] args) {
        System.out.println("test");
    }
}

