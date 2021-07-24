package testWait;

public class test1 {
    public static void main(String[] args) {
        // int[] arr = {3,4,5,6,7,8,9,1,2};
        int[] arr = {6,7,0,1,2,3,4,5};

        int left = 0;
        int right = arr.length-1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(arr[left] > arr[mid]){
                right = mid + 1 ;
            }else if(arr[mid] > arr[right]){
                left = mid + 1;
            }else{
                break;
            }
        }
        System.out.println("left = " + left);

    }
}
