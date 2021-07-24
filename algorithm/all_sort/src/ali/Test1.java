package ali;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0){
            int n = sc.nextInt();
            int qCount = sc.nextInt();
            int[] arr = new int[n];
            for (int i=0;i<n;i++){
                arr[i] = sc.nextInt();
            }
            while (qCount-- > 0){
                int index = sc.nextInt();
                int target = sc.nextInt();
                int result = find(arr,index,target);
                System.out.println(result);
            }
        }
    }

    private static int find(int[] arr, int index, int target) {
        // 前找：
        int result = Integer.MAX_VALUE;
        for (int i = index;i<arr.length;i++){
            if (arr[i] == target){
                result = Math.min(result,i-index);
                break;
            }
        }
        for (int i = index;i >= 0;i--){
            if (arr[i] == target){
                result = Math.min(result,index - i);
                break;
            }
        }
        return result;
    }
}
