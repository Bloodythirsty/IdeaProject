import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class _offer40 {

    public static void main(String[] args) {
        int[] arr = {0,1,1,2,4,4,1,3,3,2};
        int k = 6;
        getLeastNumbers(arr,k);
    }


    public static int[] getLeastNumbers_0(int[] arr, int k) {
        if(arr == null || arr.length == 0 || k == 0) return new int[0];
        Queue<Integer> heap = new PriorityQueue<>((a, b)-> b-a);
        for(int i=0;i<k;i++){
            heap.add(arr[i]);
        }

        for(int i=k;i<arr.length;i++){
            if(arr[i] < heap.peek()){
                heap.poll();
                heap.add(arr[i]);
            }
        }

        int[] res = new int[k];
        for(int i=0;i<k;i++){
            res[i] = heap.poll();
        }

        return res;
    }

    public static  int[] getLeastNumbers(int[] arr, int k) {
        if(arr == null || arr.length == 0 || k == 0) return new int[0];
        partition(arr,0,arr.length-1,k);
        return Arrays.copyOfRange(arr,0,k);
    }

    static void partition(int[] arr,int start, int end, int k){
        int povit = arr[start];
        int low = start;
        int high = end;

        while(low < high){
            while(low < high && arr[high] >= povit){
                high--;
            }
            arr[low] = arr[high];
            while(low < high && arr[low] <= povit){
                low--;
            }
            arr[high] = arr[low];
        }
        arr[low] = povit;

        if(low+1 == k) return;
        else if(low+1 < k) partition(arr,start,low-1,k);
        else partition(arr,low+1,end,k);
    }
}
