import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Stream;

public class TestMath {

    @Test
    public void test1(){
        System.out.println((int)Math.pow(10, 2));
    }

    @Test
    public void test(){
        int[] a = {0,1,2,3,4,5,6,7,8,9};
        for (int i : a) {
            System.out.print(",i = " + i);
        }
        System.out.println("------------------- = ");
        int[] b = new int[a.length];
        System.arraycopy(a,1,b,0, 3);
        for (int i : b) {
            System.out.print(",i = " + i);
        }

        System.out.println("-----------------------------");
        int[] c = new int[10];
        Arrays.fill(c,1,5,-1);
        for (int i : c) {
            System.out.print(",i = " + i);
        }
    }


    // @Test
    // public double testPint(){
    //     System.out.println(5/2.0);
    //     System.out.printf("%.5f",5/2.0);
    //     double d = 0.000;
    //     int a = 2;
    //     for (int i=0,j=0;(i<5)||(j<5);i++,j++){
    //
    //     }
    //     return a/1.0;
    // }

    @Test
    public  void  yesy(){
        // System.out.println(Math.ceil(-1.2));
        // System.out.println(Math.floor(-1.2));
        // System.out.println(Math.floor(3));
        // System.out.println(Math.sqrt(8));

        int[] arr = {2,5,48};
        int asInt = Arrays.stream(arr).min().getAsInt();
        System.out.println("asInt = " + asInt);
        Arrays.sort(arr);
    }


}
