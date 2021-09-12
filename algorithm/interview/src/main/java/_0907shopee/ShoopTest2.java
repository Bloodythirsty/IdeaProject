package _0907shopee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author zhangkangkang
 * @date 2021/09/07 21:50
 */
public class ShoopTest2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> nums = new ArrayList<>();
        while (n!=0){
            int temp = n % 10;
            nums.add(0,temp);
            n /= 10;
        }

    }
}
