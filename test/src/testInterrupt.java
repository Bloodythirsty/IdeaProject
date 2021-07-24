import org.junit.Test;

public class testInterrupt {

    private static boolean isQuit = false;

    @Test
    public void testInrer1() throws InterruptedException {
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                while (!isQuit) {
                    System.out.println("我正忙着转账呢！");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("转账被终止！");
            }
        };
        thread1.start();

        Thread.sleep(5000);
        System.out.println("对方是内鬼，终止交易！");
        isQuit = true;
    }

    @Test
    public void testInrer2() throws InterruptedException {
        Thread thread2 = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("我正忙着交易呢！");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    //e.printStackTrace();
                    break;
                    // t.interrupt() 会让 t 这个线程内部触发一个异常，
                    // 当捕捉到这个异常的时候，就可以让循环结束。
                }
            }
            System.out.println("交易被警察打断！");
        });
        thread2.start();

        Thread.sleep(5000);
        System.out.println("条子来了，终止交易！");
        thread2.interrupt();

    }

    @Test
    public void testInrer3() throws InterruptedException {
        Thread thread2 = new Thread(() -> {
            while (true) {
                System.out.println("我正忙着交易呢！!");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    //e.printStackTrace();
                    System.out.println("交易被警察打断！");
                    break;
                    // t.interrupt() 会让 t 这个线程内部触发一个异常，
                    // 当捕捉到这个异常的时候，就可以让循环结束。
                }
            }

        });
        thread2.start();

        Thread.sleep(5000);
        System.out.println("条子来了，终止交易！");
        thread2.interrupt();

    }

    @Test
    public void testInrer4() throws InterruptedException {
        Thread thread2 = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println(Thread.currentThread().getName()+"：我正忙着交易呢！!");
            }
            System.out.println(Thread.currentThread().getName()+"：交易被警察打断！");

        });
        thread2.start();

        Thread.sleep(20);
        System.out.println(Thread.currentThread().getName()+":条子来了，终止交易！");
        thread2.interrupt();

    }


    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName()+"thread begin ");
                Thread.sleep(5000);
                System.out.println("thread end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();
        thread.join();
        System.out.println(Thread.currentThread().getName()+"main done");

    }


}
