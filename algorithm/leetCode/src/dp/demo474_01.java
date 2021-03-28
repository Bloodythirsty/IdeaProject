package dp;

import java.util.Objects;

public class demo474_01 {
    /*
        dp[j][k] = max{dp[j][k]，dp[j-zero[i]][k-one[i]]+1}
    */
    public static int findMaxForm(String[] strs, int m, int n) {

        //赋值
        int strsLength = strs.length;
        int[] zeros = new int[strsLength + 1];
        int[] ones = new int[strsLength + 1];
        for (int i = 0; i < strsLength; i++) {
            ones[i + 1] = onesInStr(strs[i]);
            zeros[i + 1] = strs[i].length() - ones[i + 1];
        }

        //动态规划
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= strsLength; i++) {
            //滚动二维数组
            for(int j = m; j >= 0;j--){
                for(int k = n; k >= 0;k--){
                    if((j>=zeros[i]) && (k>=ones[i]))
                        dp[j][k] = Math.max(dp[j][k],dp[j-zeros[i]][k-ones[i]]+1);
                }
            }

            // for (int j = m; j >= zeros[i]; j--) {
            //     for (int k = n; k >= ones[i]; k--) {
            //         dp[j][k] = Math.max(dp[j][k], dp[j - zeros[i]][k - ones[i]] + 1);
            //     }
            // }
            System.out.println("------------------");
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    System.out.print(dp[j][k] + " ");
                    if (k == n) System.out.println();
                }
            }
        }
        return dp[m][n];
    }
        //找1
    public static int onesInStr (String str){
        int counts = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1')
                counts++;
        }
        return counts;
    }


    public static void main (String[] args){
        String[] strs = {"10", "0", "1"};
        int m = 1;
        int n = 1;
        int maxForm = findMaxForm(strs, m, n);
        System.out.println("maxForm = " + maxForm);
    }
}

class NodeDemo{
    int key,val;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NodeDemo nodeDemo = (NodeDemo) o;
        return key == nodeDemo.key &&
                val == nodeDemo.val;
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, val);
    }
}