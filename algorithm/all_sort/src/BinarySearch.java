import org.junit.Test;

public class BinarySearch {

    int binarySearch_1(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1; // 注意

        while(left <= right) { // 注意此处闭区间
            int mid = (right + left) / 2;
            if(nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                left = mid + 1; // 注意
            else if (nums[mid] > target)
                right = mid - 1; // 注意
        }
        return -1;
    }

    int binarySearch_2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1; // 注意

        while(left < right) { // 注意此开区间
            int mid = (right + left) / 2;
            if(nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                left = mid + 1; // 注意
            else if (nums[mid] > target)
                right = mid - 1; // 注意
        }
        return -1;
    }

    int binarySearch_2_1(int[] nums, int target) {
        int left = 0;
        int right = nums.length; // 注意

        while(left < right) { // 注意此右端开区间
            int mid = (right + left) / 2;
            if(nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                left = mid + 1; // 注意
            else if (nums[mid] > target)
                right = mid ; // 注意: 此处是右端开区间
        }
        return -1;
    }

    @Test
    public void test(){
        int[] a = {0,1,2,3,5};
        System.out.println(binarySearch_1(a,1));
        // 这个算法，当 l=1,h=1时，停止比较，即1没有比较上！！
        System.out.println(binarySearch_2(a,1));

        System.out.println(binarySearch_2_1(a,1));
    }



    /*
            输出 小于等于target的元素个数
            a={-1,1,2,2,2,2,3,3,4,5,6,7,8,9,10};
            target=1  输出2
            target = -3 输出0
            target = 12 输出15=数组长度

            存在问题：找不到怎么办，可加个标志
     */
    int right_bound(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0, right = nums.length;

        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                left = mid + 1; // 注意
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        return left; // 注意
    }
    @Test
    public void testRight(){
        int[] a={-1,1,2,2,2,2,3,3,4,5,6,7,8,9,10};
        System.out.println(right_bound(a,15));
    }


    /*
            左侧算法：含义：会返回数组中小于指定数的个数

     */
    public int left_bound(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0;
        int right = nums.length; // 注意

        while (left != right) { // 注意
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid; // 注意
            }
        }
        return left;
    }
    @Test
    public void testLeft(){
        int[] a={-2,-1,0,1,2,2,2,2,4,5};
//        int[] a={1};
        System.out.println(left_bound(a,-1));
    }

}
