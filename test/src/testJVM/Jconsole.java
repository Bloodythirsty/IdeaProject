package testJVM;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
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
        int i=0,j=0;
        for(;(i < 1) & (j < 1);){

        }

        ArrayList[] lists = new ArrayList[33];
        Arrays.fill(lists,new ArrayList<Integer>());
        for (Object o : lists[0]) {

        }
        for (ArrayList arrayList : lists) {

        }
    }
}
