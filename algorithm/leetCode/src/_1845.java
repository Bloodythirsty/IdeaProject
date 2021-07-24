public class _1845 {
    public static void main(String[] args) {
        SeatManager seatManager = new SeatManager(2);
        int reserve = seatManager.reserve();
        seatManager.unreserve(1);
        int reserve1 = seatManager.reserve();
        int reserve2 = seatManager.reserve();
        seatManager.unreserve(2);
        int reserve3 = seatManager.reserve();
        seatManager.unreserve(1);
        int reserve4 = seatManager.reserve();
        seatManager.unreserve(2);
        int reserve5 = seatManager.reserve();
    }
}
class SeatManager {

    private int[] arr;
    private int minIndex ;

    public SeatManager(int n) {
        arr = new int[n];
        minIndex = 0;
    }

    public int reserve() {
        int res = minIndex+1;
        arr[minIndex] = 1;
        for(int i=minIndex+1;i<arr.length;i++){
            if(arr[i] == 0) {
                minIndex = i;
                break;
            }
        }
        return res;
    }

    public void unreserve(int seatNumber) {
        if(minIndex >= seatNumber){
            minIndex = seatNumber-1;
        }
        arr[seatNumber-1] = 0;
    }
}