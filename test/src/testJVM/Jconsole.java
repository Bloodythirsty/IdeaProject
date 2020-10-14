package testJVM;

import java.util.ArrayList;
import java.util.List;

public class Jconsole {
    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("start = ");
        test1(10000);

    }

    public static void test1(int num) throws InterruptedException {
        final int _128k = 128*1024;
        List<byte[]> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Thread.sleep(100);
            list.add(new byte[_128k]);
        }
    }
}
