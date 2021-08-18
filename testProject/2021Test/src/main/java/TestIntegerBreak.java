import java.util.Arrays;
import java.util.Map;

public class TestIntegerBreak {

    public static void main(String[] args) {
        int n = 10;
        // double sq = Math.sqrt(n);
        // int ceilInt = (int)Math.ceil(sq);
        // int floorInt = (int)Math.floor(sq);
        // long res1 = getMax(n,ceilInt);
        // long res2 = getMax(n,floorInt);
        // return;

        int[] dp = new int[n+1];
        Arrays.fill(dp,1);

        for (int i = 3; i <= n ; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i-j]*j,(i-j)*j);
            }
        }


    }

    public static long getMax(int n, int i){
        if(n == i) return 0;
        int times = n / i;
        int last1 = n - i*(times-1);
        int last2 = n - i*times;
        long res1 = 0;
        if (times-1 != 0){
            res1 =  (long)(last1*Math.pow(i,times-1));
        }
        long res2 =  (long)(last2*Math.pow(i,times));
        return (long)(Math.max(res1,res2));
    }
}
