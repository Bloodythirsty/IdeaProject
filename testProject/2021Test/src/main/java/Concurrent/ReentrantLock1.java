package Concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by kangkang on 2021/3/21 19:48
 */
public class ReentrantLock1 {

    public static void main(String[] args) {
        MytaskThree task = new MytaskThree();
        new Thread(()->{
            while (true){
                try {
                    task.task1();
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(()->{
            while (true){
                try {
                    task.task2();
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(()->{
            while (true){
                try {
                    task.task3();
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}


class MytaskThree{
    ReentrantLock rl = new ReentrantLock();
    Condition c1 = rl.newCondition();
    Condition c2 = rl.newCondition();
    Condition c3 = rl.newCondition();



    int flag = 1;

    public  void task1() throws InterruptedException {
        rl.lock();	// AQS的status=1
        System.out.println("1.task lock");

        while(flag != 1) {
            System.out.println("flag != 1");
            c1.await();
        }

        System.out.println("1.task.");
        flag = 2;

        c2.signal();

        System.out.println("c2.signal();");
        rl.unlock();
        System.out.println("1.task unlock");
        System.out.println(" ====== ");
    }

    public  void task2() throws InterruptedException {
        rl.lock();
        System.out.println("2.task lock");

        while(flag != 2) {
            System.out.println("flag != 2");
            c2.await();
        }

        System.out.println("2.task.");
        flag = 3;

        c3.signal();
        System.out.println("c3.signal();");

        rl.unlock();
        System.out.println("2.task unlock");

        System.out.println(" ====== ");
    }

    public  void task3() throws InterruptedException {
        rl.lock();
        System.out.println("3.task lock");

        while(flag != 3) {
            System.out.println("flag != 3");
            c3.await();
        }

        System.out.println("3.task.");
        flag = 1;

        c1.signal();
        System.out.println("c1.signal();");

        rl.unlock();
        System.out.println("3.task unlock");

        System.out.println(" ====== ");
    }
}
