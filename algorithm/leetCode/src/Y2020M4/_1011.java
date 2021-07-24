package Y2020M4;

import java.util.stream.IntStream;

public class _1011 {
    public static void main(String[] args) {
        int[] arr = {3,3,3,3,3,3};
        shipWithinDays(arr,2);
    }

    public static int shipWithinDays(int[] weights, int D) {
        int left = IntStream.of(weights).max().getAsInt();
        int right = IntStream.of(weights).sum();

        while(left < right){
            int mid = left + (right - left)/2;
            if(canShip(weights,D,mid)){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return right;
    }

    public static boolean canShip(int[] weights,int D, int capicity){
        int serialCount = 0;
        int days = 1;
        for(int weight:weights){
            int temp = serialCount + weight;
            if( temp > capicity){
                days++;
                serialCount = weight;
            }else{
                serialCount = temp;
            }
        }
        return days <= D;  // 剩余天数大，说明容量大，刚好等于1，说明刚好天数
    }
}
