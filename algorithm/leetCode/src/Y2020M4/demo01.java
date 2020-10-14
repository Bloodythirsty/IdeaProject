package Y2020M4;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
        给出nums数组，target
        找出两个数和为target的两个下标
 */
public class demo01 {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] ints = twoSum2(nums, target);
        System.out.println(Arrays.toString(ints));
    }

    /*
            时间复杂度   n2
     */
    public static int[] twoSum1(int[] nums, int target) {
        int[] arr = new int[2];
        for ( int i = 0; i < nums.length - 1; i++){
            for (int j = i+1; j < nums.length; j++) {
                if ( target == (nums[i] + nums[j])){
                    arr[0] = i;
                    arr[1] = j;
                    break;
                }
            }
        }
        return arr;
    }

    /**
     *
        时间复杂度 n
     思路：
        1. 利用map集合，互补的原理
        2. 先用target减去数组每个数，和下表存入map
        3. 当每次遍历，判断map是否包含次数，包含代表对应的另一个加数已经被减
        4. 取出那个map里面与本加数对应的下标，及其本下标即可
     */
    public static int[] twoSum2(int[] nums, int target) {
        int[] arr = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0 ; i < nums.length ; i++){
            if ( map.containsKey(nums[i]) ){
                arr[0] = map.get(nums[i]);
                arr[1] = i;
                break;
            }
            map.put(target-nums[i], i);
        }
        return arr;
    }
}
