package bianlif;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String source = sc.nextLine();
        int k = sc.nextInt();
        String[] numsStr = source.split(",");
        int[] nums = new int[numsStr.length];
        for (int i = 0; i < numsStr.length; i++) {
            nums[i] = Integer.parseInt(numsStr[i]);
        }

        int[] res = new int[nums.length - k +1];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int j=0,i=1-k; j<nums.length;i++,j++){
            if(i>0 && deque.peekFirst() == nums[i-1]){
                deque.removeFirst();
            }
            while(!deque.isEmpty() && deque.peekLast() < nums[j]){
                deque.removeLast();
            }
            deque.addLast(nums[j]);
            if (i >= 0){
                res[i] = deque.peekFirst();
            }
        }

        System.out.print("[");
        System.out.print(res[0]);
        for (int i = 1; i < res.length; i++) {
            System.out.print(","+res[i]);
        }
        System.out.print("]");
    }
}
