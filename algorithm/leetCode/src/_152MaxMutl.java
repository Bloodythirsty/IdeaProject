public class _152MaxMutl {
    public static void main(String[] args) {
        int[] arr = {-4,-3,-2};
        maxProduct(arr);
    }

    public static int maxProduct(int[] nums) {
        int min = nums[0];
        int max = min;
        int res = max;

        for(int i=1;i<nums.length;i++){
            int tempMax = max, tempMin = min;
            max = Math.max(nums[i],Math.max(nums[i]*tempMax,nums[i]*tempMin));
            min = Math.min(nums[i],Math.min(nums[i]*tempMax,nums[i]*tempMin));
            res = Math.max(max,res);
        }
        return res;
    }
}
