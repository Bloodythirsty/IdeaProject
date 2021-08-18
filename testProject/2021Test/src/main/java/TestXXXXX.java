public class TestXXXXX {
    public static void main(String[] args) {
        // String s = "cbbd";
        String s = "aaaa";
        String s1 = longestPalindrome(s);
        System.out.println("s1 = " + s1);
    }

    public static String longestPalindrome(String s) {
        int size = s.length();
        boolean[][] dp = new boolean[size][size];
        for(int i=0;i<size;i++){
            dp[i][i] = true;
        }
        int start = 0;
        int maxLength = 1;

        for(int i=size-2;i>=0;i--){
            for(int j = i+1; j < size;j++){
                boolean isHui = (s.charAt(i) == s.charAt(j)) && ((j-i) < 2  || dp[i+1][j-1]);
                if(isHui){
                    start = i;
                    maxLength = j - i + 1;
                }
            }
        }

        return s.substring(start,start+maxLength);
    }
}
