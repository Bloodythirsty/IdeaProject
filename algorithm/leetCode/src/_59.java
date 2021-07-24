import java.util.ArrayDeque;
import java.util.Deque;

public class _59 {
    public static void main(String[] args) {

        int[] arr = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        maxSlidingWindow(arr,3);
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0 || k == 0) return new int[0];
        Deque<Integer> deque = new ArrayDeque<>();
        int[] res = new int[nums.length - k + 1];

        //形成单调窗口(窗口存下表，方便判断是否在窗口内)
        for(int i=0;i<k;i++){
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]){
                deque.pollLast();
            }
            deque.addLast(i);
        }
        res[0] = nums[deque.peekFirst()];
        for(int i=k;i<nums.length;i++){
            // 形成单调
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]){
                deque.pollLast();
            }
            // 把不在滑动窗口内的剔除
            if(!deque.isEmpty() && deque.peekFirst() <= i - k){
                deque.pollFirst();
            }
            deque.addLast(i);
            res[i-k+1] = nums[deque.peekFirst()];
        }
        return res;
    }
}
