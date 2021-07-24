package testLock;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class ZeroEvenOdd {
    private int n;
    Semaphore s1;
    Semaphore s2;
    Semaphore s0;
    int i = 0;

    public ZeroEvenOdd(int n) {
        this.n = n;
        s0 = new Semaphore(1);
        s1 = new Semaphore(0);
        s2 = new Semaphore(0);
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        while(i <= n){
            s0.acquire();
            printNumber.accept(0);
            i++;
            if(i%2==1){
                s1.release();
            }else{
                s2.release();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        while(i <= n){
            s1.acquire();
            printNumber.accept(i);
            s0.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        while(i <= n){
            s2.acquire();
            printNumber.accept(i);
            s0.release();
        }
    }

    public static void main(String[] args) {
        ZeroEvenOdd zeo = new ZeroEvenOdd(5);

        new Thread(()->{
            try {
                zeo.zero(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {
                zeo.odd(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {
                zeo.even(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}