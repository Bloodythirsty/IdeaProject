package _0903beike;

import java.util.Scanner;

public class BeikeTest1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            countNum(N);
        }
    }

    private static void countNum(int n) {
        int result = (n+1)/2;
        System.out.println(result);
    }
}


/*

    木头拼接
 */
