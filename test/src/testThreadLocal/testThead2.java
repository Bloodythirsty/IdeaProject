package testThreadLocal;

public class testThead2 {
    public static void main(String[] args) {
        TicketTask task = new TicketTask();
        //创建线程
        Thread t1 = new Thread(task);	//放的是同一个对象，若每次new TicketTask();则锁中的this不一样，即线程仍不安全
        Thread t2 = new Thread(task);
        Thread t3 = new Thread(task);
        Thread t4 = new Thread(task);

        //开启线程
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
class TicketTask implements Runnable {
    int tickets = 100;

    @Override
    public void run() {

        while (true) {
           synchronized (this) {
                if (tickets <= 0) {
                    System.out.println(Thread.currentThread().getName() + "Ticket is over!");
                    break;
                } else {
                    System.out.println(Thread.currentThread().getName() + "Congraduation! your ticket is " + tickets);
                    tickets--;
                }

           }
        }
    }
}