package _0926huawei;

import java.util.Arrays;

/**
 * @author zhangkangkang
 * @date 2021/09/26 17:44
 */
public class HuaweiTest2 {
    public static void main(String[] args) {
        int[] nums = {1,2,1,2,3,4};
        int[] result = find(nums);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    private static int[] find(int[] nums) {
        int[] result = new int[2];
        int x1 = 0;
        for (int i = 0; i < nums.length; i++) {
            x1 ^= nums[i];
        }
        int index = 0;
        for (int i = 0; i < 32; i++) {
            if ((x1>>i)==1){
                index = i;
                break;
            }
        }

        int result1 = 0;
        int result2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i]>>index) == 0){
                result1 ^= nums[i];
            }else {
                result2 ^= nums[i];
            }
        }
        result[0]=result1;
        result[1]=result2;
        return result;
    }
}
