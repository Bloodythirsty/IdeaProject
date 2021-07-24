package testLock;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class TestSephore {
    public static void main(String[] args) {
        Semaphore s1 = new Semaphore(0);
        Semaphore s2 = new Semaphore(0);


        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "--1111");
            s1.release();
        }).start();

        new Thread(() -> {
            try {
                s1.acquire();
                System.out.println(Thread.currentThread().getName() + "--2222");
                s2.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                s2.acquire();
                System.out.println(Thread.currentThread().getName() + "--33333");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }
}


