package dp;

import org.junit.Test;

import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

/*
10 背包容量，4 物体个数
2 第一个物体容量，1 第一个物体价值

10 4
2 1
3 3
4 5
7 9

 */

public class demo01_0_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[] w = new int[n+1];
        int[] v = new int[n+1];
        for (int i=1;i<=n;i++){
            w[i]=sc.nextInt();
            v[i]=sc.nextInt();
        }
        // int i = solve_0_1_1(n, m, w, v);
        int i = solve_0_1_1(n, m, w, v);
        System.out.println("i = " + i);
    }
    public static int solve_0_1(int n,int m,int[] w,int[] v){
        int[][] dp = new int[n+1][m+1];
        //循环顺序：因为dp[i][j]用到了dp[i-1][j]
        //从 1 1开始，0位置默认0
        for(int i = 1;i<=n;i++)
            for(int j = 1;j <=m;j++){
                //f[1][...]
                if(j < w[i]){	//第i个物体的体积超过总容量，则直接不拿第i个物体,以 dp[i-1][j] 当作当前值
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-w[i]] + v[i]);
                }
                // if(j>w[i]){
                //     dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-w[i]] + v[i]);
                // }
            }

        for(int i = 0;i<= n;i++)
            for(int j = 0;j <= m;j++){
                System.out.print(dp[i][j]+" ");
                if ( j == m) System.out.println();
            }

        return dp[n][m];
    }

    public static int solve_0_1_1(int n,int m,int[] w,int[] v){
        int[] dp = new int[m+1];
        //循环顺序：因为dp[i][j]用到了dp[i-1][j]
        //从 1 1开始，0位置默认0
        for(int i = 1;i<=n;i++){
            // for(int j = m;j >= 1;j--){
            for(int j = 1;j <= m;j++){
                if(j >= w[i]){
                    dp[j] = Math.max(dp[j], dp[j-w[i]] + v[i]);
                }

            }
            for (int k = 0; k <= m; k++) {
                System.out.print(dp[k]+" ");
                if ( k == m) System.out.println();
            }
        }

        return dp[m];
    }

    @Test
    public void testCon(){
        ConcurrentHashMap<String, String> stringStringConcurrentHashMap = new ConcurrentHashMap<>(66);

        HashMap<String,String> map = new HashMap<>();
        System.out.println(map instanceof HashMap);
    }
}
