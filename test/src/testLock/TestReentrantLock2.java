package testLock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class TestReentrantLock2 {
    static  int i = 1;
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
                i++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                c1.signal();
                lock.unlock();
                System.out.println("1 unlock");
            }
        }).start();

        new Thread(() -> {
            try {
                lock.lock();
                System.out.println("c2 lock");
                while (i != 2){
                    c1.await();
                }
                System.out.println(Thread.currentThread().getName() + "--2222");
                i++;
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
                while(i!=3){
                    c2.await();
                }
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


