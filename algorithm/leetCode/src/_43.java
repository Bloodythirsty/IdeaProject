import java.util.ArrayList;
import java.util.List;

public class _43 {
    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "456";
        multiply(num1,num2);
    }

    public static void multiply(String num1, String num2) {
        List<String> everyResult = new ArrayList<>();
        for(int i=num2.length()-1;i>=0;i--){
            String result = handleEveryResult(num2.charAt(i),num1,num2.length()-1-i);
            everyResult.add(result);
        }
        String result = everyResult.get(0);
        for(int i=1;i<everyResult.size();i++){
            result = addTwoString(result,everyResult.get(i));
        }
    }

    static String handleEveryResult(char c, String num1, int zeroNum){
        int intC = c - '0';
        int yushu = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=num1.length()-1;i>=0;i--){
            int temp = num1.charAt(i) - '0';
            int mutl = temp*intC + yushu;
            sb.insert(0,mutl%10);
            yushu = mutl/10;
        }
        if(yushu != 0) sb.insert(0,yushu);
        for(int i=0;i<zeroNum;i++){
            sb.append(0);
        }
        return sb.toString();
    }

    static String addTwoString(String str1,String str2){
        int int1 = 0;
        int int2 = 0;
        int yushu = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=str1.length()-1,j = str2.length()-1; i>=0 || j>=0;i--,j--){
            if( i < 0) int1 = 0;
            else int1 = str1.charAt(i) - '0';
            if( j < 0) int2 = 0;
            else int2 = str2.charAt(j) - '0';
            int result = int1 + int2 + yushu;
            sb.insert(0,result%10);
            yushu = result/10;
        }
        if(yushu != 0) sb.insert(0,yushu);
        return sb.toString();
    }
}
