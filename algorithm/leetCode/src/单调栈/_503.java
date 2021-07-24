package 单调栈;

import java.util.ArrayDeque;
import java.util.Deque;

public class _503 {
    public static void main(String[] args) {
        int[] arr = {1,2,1};
        nextGreaterElements(arr);
    }

    public static int[] nextGreaterElements(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        int n = nums.length;
        int[] res = new int[n];
        for(int i=n*2-1;i>=0;i--){
            int realI = i%n;
            while(!stack.isEmpty() && stack.peek() <= nums[realI]){
                stack.pop();
            }
            res[realI] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[realI]);
        }
        return res;
    }
}
