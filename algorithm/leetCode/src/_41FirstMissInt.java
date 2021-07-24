public class _41FirstMissInt {
    public static void main(String[] args) {
        int[] res = {7,8,9,11,12};
        firstMissingPositive(res);
    }
    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(nums[i] <=0 ) nums[i] = n+1;
        }
        for(int i=0;i<n;i++){
            if(nums[i]<=n) nums[nums[i]-1] = -nums[nums[i]-1];
        }

        int res = 0;
        for(int i=0;i<n;i++){
            if(nums[i]>0) res = i+1;
        }
        return res;

    }
}
