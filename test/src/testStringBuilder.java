import org.junit.Test;

import java.util.ArrayList;

public class testStringBuilder {
    @Test
    public void testBuidl(){
        StringBuilder sb = new StringBuilder();
        StringBuilder append = sb.append(123);
        System.out.println(sb.toString());
        char[] chars={'a','v','c','g'};
        sb.append(chars,0,2);
        System.out.println(sb.toString());

    }

    @Test
    public void testBool(){

        boolean[] bs = new boolean[10];
        for (boolean b : bs) {
            System.out.println("b = " + b);
        }

    }

    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String ans = "";
        for (int inclineRow = 0; inclineRow < n; ++inclineRow) {
            for (int i = 0; i + inclineRow < n; ++i) {
                int j = i + inclineRow;
                if (inclineRow == 0) {
                    dp[i][j] = true;
                } else if (inclineRow == 1) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]);
                }
                if (dp[i][j] && inclineRow + 1 > ans.length()) {
                    ans = s.substring(i, i + inclineRow + 1);
                }
            }
        }
        return ans;
    }

    @Test
    public void test(){
        double f = Double.parseDouble("2.3");
        double f1 = f - (int)Math.floor(f);
        int result;
        if(f1 >= 0.5){
            result = (int)Math.floor(f);
        }else{
            result = (int)Math.ceil(f);
        }
        System.out.println(result);
    }
}
