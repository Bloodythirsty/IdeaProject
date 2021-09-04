package 单调栈;

import java.util.LinkedList;

/**
 * @author zhangkangkang
 * @date 2021/08/12 19:36
 */
public class _907连续子数组最小值之和 {
    public static void main(String[] args) {
        int res = 0;
        int[] arr = {3,1,2,4};
        for(int i=1;i<=arr.length;i++){
            res = (res + minWindow(arr,i))%(1000000007);
        }
        System.out.println("res = " + res);
    }

    public static int minWindow(int[] arr, int k){
        int res = 0;
        LinkedList<Integer> stack = new LinkedList<>();
        stack.addLast(0);
        for(int i=1;i<k;i++){
            while(!stack.isEmpty() && arr[stack.peekLast()] > arr[i]){
                stack.pollLast();
            }
            stack.addLast(i);
        }
        res += arr[stack.peekFirst()];

        for(int i=k;i<arr.length;i++){
            while(!stack.isEmpty() && arr[stack.peekLast()] > arr[i]){
                stack.pollLast();T
            }
            stack.addLast(i);
            if(!stack.isEmpty() && stack.peekFirst() < i-k+1){
                stack.pollFirst();
            }
            res += arr[stack.peekFirst()];
        }
        return res%(1000000007);
    }
}
