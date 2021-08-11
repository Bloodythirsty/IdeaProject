package _0808meituan;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author zhangkangkang
 * @date 2021/08/08 9:24
 */
public class MeiTuan1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TNums = sc.nextInt();
        for(int i=0;i<TNums;i++){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[n];
            for(int j=0;j<n;j++){
                arr[j] = sc.nextInt();
            }

            if(k == n){
                System.out.println("NO");
                continue;
            }
            if(k == 0){
                System.out.println("YES");
                System.out.println(1);
                continue;
            }

            Arrays.sort(arr);

            int res = arr[k-1]+1;
            if(res > n || arr[k-1]==arr[k] || res > arr[k]){
                System.out.println("NO");
            }else{
                System.out.println("YES");
                System.out.println(res);
            }

        }
    }
}
