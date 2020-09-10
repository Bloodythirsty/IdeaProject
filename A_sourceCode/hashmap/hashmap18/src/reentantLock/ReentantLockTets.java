package reentantLock;

import oracle.jrockit.jfr.events.RequestableEventEnvironment;

import java.util.concurrent.locks.ReentrantLock;

public class ReentantLockTets {
    public static void main(String[] args) throws InterruptedException {
        final ReentrantLock reentrantLock = new ReentrantLock();

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        }).start();

        new Thread(() -> {
            reentrantLock.lock();
            System.out.println("Thread 1 get the lock~");
            try {
                Thread.sleep(30*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            reentrantLock.unlock();
        }).start();

        Thread.sleep(1000);

        new Thread(() -> {
//            reentrantLock.lock();
            while (!reentrantLock.tryLock()){           //tryLock() ， 尝试去锁，未获取到返回false，不会阻塞
                System.out.println("Thread 2 didn't get lock~");
                reentrantLock.lock();                   //获取锁，一直等待，会阻塞
            }
            System.out.println("Thread 2 get lock~");
        }).start();
    }
}
