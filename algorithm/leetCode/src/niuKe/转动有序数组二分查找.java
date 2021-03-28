package niuKe;

public class 转动有序数组二分查找 {
    public static void main(String[] args) {
        int[] s = {4, 5, 6, 7, 0, 1, 2};
        int i = find(s, 3);
        System.out.println("i = " + i);
    }

    public static int find(int[] A,int target){
        /*int low = 0;
        int high = a.length;
        while (low < high){
            int mid = (high + low)>>1;
            if (a[mid] == target) return mid;
            else if (a[low] ==target) return low;
            else if (a[high-1]==target) return high-1;
            else if (target < a[mid] && target < a[low]) low = mid+1;
            else if (target < a[mid] && target > a[low]) high = mid;
            else if (target > a[mid] && target < a[low]) low = mid+1;
            else if (target > a[mid] && target > a[low]) high = mid;
        }
        return -1;*/

        int left = 0, right = A.length-1;

        while(left <= right){
            int mid = left + (right-left)/2;
            if(A[mid] == target)
                return mid;
            if(A[mid] >= A[left]){
                //左边有序
                //目标值大于中间值，且，最左边小于等于目标值，则目标值在左边有序空间里
                if(A[mid] > target && A[left] <= target){
                    right = mid - 1;
                    //左边有序的情况下，target不在左边有序里
                }else{
                    left = mid + 1;
                }
            }else{
                //右边有序
                //目标值大于中间值，且，最右边大于等于目标值，则目标值在右边有序空间里
                if(A[mid] < target && A[right] >= target){
                    left = mid + 1;
                //右边有序的情况下，target不在右边有序里
                }else{
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
