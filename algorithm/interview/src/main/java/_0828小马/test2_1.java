package _0828小马;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author zhangkangkang
 * @date 2021/08/28 15:37
 */
public class test2_1 {


    public static int result = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        List<Integer> xIndex = new ArrayList<>();
        List<Integer> yIndex = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            xIndex.add(sc.nextInt());
            yIndex.add(sc.nextInt());
        }
        List<Integer> lengths = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int x = xIndex.get(i);
            int y = yIndex.get(i);
            if (y == 0){
                lengths.add(x);
            }else if (x == n){
                lengths.add(n+y);
            }else if (y == n){
                lengths.add(n*3-x);
            }else {
                lengths.add(n*4-y);
            }
        }

        Collections.sort(lengths);
        for (int i = 0; i < m; i++) {
            lookRightAndLeft(i,lengths,n,k);
        }
        System.out.println(result);
    }

    private static void lookRightAndLeft(int i, List<Integer> lengths,int n,int k) {
        // 右边找
        int rightLeng = 0;
        int Rindex = (i + k - 1 + n)%n;
        rightLeng = (lengths.get(Rindex) - lengths.get(i) + n*4)%(n*4);
        result = Math.min(rightLeng,result);

        // 左边找
        int leftLeng = 0;
        int Lindex = (i - k + 1 + n)%n;
        leftLeng = (lengths.get(i) - lengths.get(Lindex) + n*4)%(n*4);
        result = Math.min(leftLeng,result);
    }
}


/*
5 5 3
5 3
0 0
0 4
3 0
1 5

5 5 5
5 3
0 0
0 4
3 0
1 5

 */