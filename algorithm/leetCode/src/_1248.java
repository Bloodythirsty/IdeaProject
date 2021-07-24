public class _1248 {
    public static void main(String[] args) {
        int[] arr = {1,1,2,1,1};
        numberOfSubarrays(arr,3);
    }

    public static int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        // int[] dp = new int[n];
        int last = 0, now = 0;
        int count = 0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(j==i && (nums[j]&1)==1){
                    now = 1;
                }else if((nums[j]&1)==1){
                    now = last+1;
                }else{
                    now = last;
                }
                last = now;
                if(last == k) count++;
            }
        }
        return count;
    }
}
