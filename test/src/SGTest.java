import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

public class SGTest {

    // private static volatile
    public static void main(String[] args) throws FileNotFoundException {
        String  source = "噶上海自来水来自海上而厄尔";
        String ab = ab(source);
        System.out.println("ab = " + ab);

        double log = Math.log(Math.E);
        System.out.println("log = " + log);
    }

    static String ab(String source){
        int n = source.length();
        boolean[][] dp = new boolean[n][n];
        for(int i=0;i<n;i++){
            dp[i][i] = true;
        }
        // abcdcef
        // dp[i][j] = dp[i+1][j-1]

        int start = 0;
        int max = 1;
        for(int i=n-2;i>=0;i--){
            for(int j=i+1;j<n;j++){
                if((source.charAt(i) == source.charAt(j)) && (j - i < 2 || dp[i+1][j-1])){
                    dp[i][j] = true;
                    if(j - i + 1 > max){
                        start = i;
                        max = j - i + 1;
                    }
                }
            }
        }

        return source.substring(start,start+max);
    }
}

// 求最长回文串