package testJVM;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLock {
    public static void main(String[] args) {
        deadLock();
    }

    private static void deadLock(){
        Lock lock1 = new ReentrantLock();
        Lock lock2 = new ReentrantLock();

        new Thread(() -> {
            try {
                lock1.lock();
                Thread.sleep(100);
                lock2.lock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"Thread1_heh").start();

        new Thread(() -> {
            try {
                lock2.lock();
                Thread.sleep(100);
                lock1.lock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"Thread2_gag").start();
    }
}
