import org.junit.Test;

public class Test_面试笔试 {

    @Test
    public void testByte(){
        Short a = 128;
        // Byte b = (Byte)a;
        System.out.println("b = ");

    }


    public static void main(String[] args){
        //创建两个线程

        Thread t1 = new Thread() {
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("女"+i);
                    try {
                        currentThread().sleep(10);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        };

        Thread t2 = new Thread() {
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println("男"+i);
                    try {
                        currentThread().sleep(100);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        };

        /*
        setDaemon能否在start之后执行
         */

        //设置守护线程
        t2.setDaemon(true);
        t1.start();
        t2.start();

        //t2.setDaemon(true);

    }


    @Test
    public void testStringCharArr() {
        String s= "abc";
        char c[] = {'a','b','c'};
        System.out.println(s.equals(c));
        System.out.println(s.equals(new String("abc")));
    }
}
