package _0901alibaba;

import java.util.Scanner;

public class AliTest1 {
    public static void main(String[] args) {
        int EXP = 1000000007;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] temp = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = n-1; i > 0; i--) {
            for (int j = i; j > 0; j--) {
                temp[j-1] = (arr[j] - arr[j-1])%EXP;
            }
            System.arraycopy(temp,0,arr,0,i);
        }
        System.out.println(temp[0]);
    }
}

/*

4
1 2 3 4
 */
