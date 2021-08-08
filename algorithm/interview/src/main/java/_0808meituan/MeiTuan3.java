package _0808meituan;

import java.util.*;

/**
 * @author zhangkangkang
 * @date 2021/08/08 11:00
 */
public class MeiTuan3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }

        int result = 0;
        for(int i=1;i<n;i++){
            int[] preArr = Arrays.copyOfRange(arr, 0, i);
            Arrays.sort(preArr);
            int index = left_bound(preArr, arr[i]);
            if(index > 0){
                result += (i+1)*preArr[index-1];
            }
        }
        System.out.println(result);
    }


    public static int left_bound(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0;
        int right = nums.length; // 注意

        while (left != right) { // 注意
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid; // 注意
            }
        }
        return left;
    }
}
