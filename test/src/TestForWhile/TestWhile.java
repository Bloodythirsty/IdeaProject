package TestForWhile;

import java.util.Arrays;

public class TestWhile {
    public static void main(String[] args) {
        int i=100;
        while (i>0){
            i--;
        }
        System.out.println("done");

        int[] arrays = {7,8,2,3,5,0,1,1,3};
        int[] left = Arrays.copyOfRange(arrays, 0, 0);
        for (int i1 : left) {
            System.out.println("i1 = " + i1);
        }
    }
}
