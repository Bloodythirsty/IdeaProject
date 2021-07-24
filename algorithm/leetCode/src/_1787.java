import java.util.Arrays;

public class _1787 {
    public static void main(String[] args) {
        int[] arr = {26,19,19,28,13,14,6,25,28,19,0,15,25,11};
        // convert(arr);
        int k = 3;
        minChanges(arr,k);
    }

    private static void convert(int[] arr){
        int low = 0;
        int high = arr.length-1;
        while(low < high){
            int temp = arr[high];
            arr[high] = arr[low];
            arr[low] = temp;
            low++;
            high--;
        }
    }

    private static int minChanges(int[] nums, int k) {
        int count = 0;

        int xorR = 0;
        for(int i = 0; i < k-1;i++){
            xorR ^= nums[i];
        }
        if(nums[k-1] != xorR){
            count++;
            nums[k-1] = xorR;
        }

        for(int i=k;i<nums.length;i++){
            if(nums[i] != nums[i%k]) count++;
        }
        return count;
    }
}
