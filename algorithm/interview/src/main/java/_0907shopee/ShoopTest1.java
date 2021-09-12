package _0907shopee;

import java.util.Scanner;

/**
 * @author zhangkangkang
 * @date 2021/09/07 21:21
 */
public class ShoopTest1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String hexString = hexStringConvert(n);
        isHuiwen(hexString);
    }

    private static void isHuiwen(String hexString) {
        int left = 0, right = hexString.length()-1;
        while (left != right){
            if(hexString.charAt(left) != hexString.charAt(right)){
                System.out.println(0);
                break;
            }
            left++;
            right--;
        }
        System.out.println(1);
    }

    private static String hexStringConvert(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0){
            int temp = n % 16;
            sb.insert(0,corespendChar(temp));
            n = n / 16;
        }
//        sb.insert(0,corespendChar(n));
        return sb.toString();
    }

    private static String corespendChar(int temp) {

        if (temp == 10){
            return "A";
        }else if (temp == 11){
            return "B";
        }else if (temp == 12){
            return "C";
        }else if (temp == 13){
            return "D";
        }else if (temp == 14){
            return "E";
        }else if (temp == 15){
            return "F";
        }else {
            return ""+temp;
        }

    }
}
