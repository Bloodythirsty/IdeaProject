package _08222Tengxun;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author zhangkangkang
 * @date 2021/08/22 19:58
 */
public class TX2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int nums = sc.nextInt();
            int weight = sc.nextInt();
            ArrayList<Integer> oushu = new ArrayList<>();
            ArrayList<Integer> jishu = new ArrayList<>();
            for (int i1 = 0; i1 < nums; i1++) {
                int curr = sc.nextInt();
                if((curr&1)==0){
                    oushu.add(curr);
                }else{
                    jishu.add(curr);
                }
            }
            Collections.sort(oushu);
            Collections.sort(jishu);
            int result = 0;
            result += calculate(oushu,weight);
            result += calculate(jishu,weight);
            System.out.println(result);
        }
    }

    public static int calculate(ArrayList<Integer> list, int weight){
        int result = 0;
        int left = 0, right = list.size()-1;
        while (left < right){
            int curSum = list.get(left) + list.get(right);
            if(curSum <= weight){
                result++;
                left++;
                right--;
            }else{
                result++;
                right--;
            }
        }
        if (left == right) result++;
        return result;
    }
}
