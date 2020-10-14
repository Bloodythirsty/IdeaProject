package testWait;

public class testWait {
    public static void main(String[] args) {

        //1.´´½¨ÈÎÎñ
        MyTask task = new MyTask();

        //2.¿ªÆôÁ½¸öÏß³Ì
        new Thread() {
            public void run() {
                while(true) {
                    try {
                        task.task1();	//·Ç¾²Ì¬·½·¨,ËøÊÇthis
                    } catch (InterruptedException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                    try {
                        currentThread().sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

        new Thread() {
            public void run() {
                while(true) {
                    try {
                        task.task2();
                    } catch (InterruptedException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                    try {
                        currentThread().sleep(10);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }
}

class MyTask{
    //ÉèÖÃ±êÊ¶,1Ê±Ö´ÐÐÈÎÎñ1£¬2Ê±Ö´ÐÐÈÎÎñ2.
    int flag = 1;
    public synchronized void task1() throws InterruptedException {
        if(flag != 1) {
            this.wait();	//Ïß³ÌµÈ´ý
        }
        System.out.println("1.ÈÎÎñ~");
        flag = 2;
        this.notify();		//»½ÐÑÆäËû½ø³Ì
    }

    public synchronized void task2() throws InterruptedException {
        if(flag != 2) {
            this.wait();
        }
        System.out.println("2.ÈÎÎñ~");
        flag = 1;
        this.notify();
    }
}
