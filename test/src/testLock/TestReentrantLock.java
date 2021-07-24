package testLock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class TestReentrantLock {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition c1 = lock.newCondition();
        Condition c2 = lock.newCondition();

        new Thread(() -> {
            try {
                Thread.sleep(2);
                lock.lock();
                System.out.println("c1 lock");
                System.out.println(Thread.currentThread().getName() + "--1111");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                try {
                    /*
                    此处不睡，c1.signal(); 可能先于c1.await();执行，导致无法唤醒
                    解决办法，加循环数字判断
                     */
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                c1.signal();
                lock.unlock();
                System.out.println("1 unlock");
            }
        }).start();

        new Thread(() -> {
            try {
                lock.lock();
                System.out.println("c2 lock");
                c1.await();
                System.out.println(Thread.currentThread().getName() + "--2222");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                System.out.println("c2 unlock");
                c2.signal();
                lock.unlock();
            }
        }).start();

        new Thread(() -> {
            try {
                lock.lock();
                System.out.println("c3 lock");
                c2.await();
                System.out.println(Thread.currentThread().getName() + "--33333");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                System.out.println("c3 unlock");
                lock.unlock();
            }
        }).start();

    }
}


