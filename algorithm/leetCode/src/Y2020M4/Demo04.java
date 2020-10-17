package Y2020M4;

import org.junit.Test;

import java.util.Arrays;

public class Demo04 {

    @Test
    public void test(){
        int[] a = {1,2};
        int[] b = {3,4};
        System.out.println(findMedianSortedArrays(a,b));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double res ;
        if(nums1.length == 0 & nums2.length == 0){
            //同为空
            res =  0.00000;
        }else if(nums1.length == 1 & nums2.length == 1){
            res = (nums1[0]+nums2[0])/2.0;
        }else if(nums1.length > 0 & nums2.length > 0){
            //同不为空数组
            res = findInTwo(nums1,nums2);
        }else if(nums1.length > 0){
            //第一个不为空
            res = findInOne(nums1);
        }else{
            //第二个不为空
            res = findInOne(nums2);
        }
        return res;
    }

    public double findInOne(int[] nums){
        int median = nums.length/2;
        //只有一个数组，直接能找到median
        if(nums.length%2 == 0)
            return (nums[median]+nums[median-1])/2.0;
        return nums[median]/1.0;
    }

    public double findInTwo(int[] nums1, int[] nums2){
        int sumLength = nums1.length + nums2.length;
        int median = sumLength/2;
        //比较遍历两个数组，找到第median个，直接返回 (nums[median]+nums[median-1])/2.0
        int count = 0,i = 0, j =0,pre=0;
        double res = 0.0;
        while(true){
            // i移动，说明j大,并且控制ij范围，假设一个数组到头，则下标不能再加
            int numsi=nums1[i],numsj=nums2[j];
            if((numsi < numsj)&(i < nums1.length-1)) {
                i++;
                count++;
            }else if ((numsi >= numsj)&(j < nums2.length-1)){
                j++;
                count++;
            }


            // 相等的时候，i和j指向median元素，但是谁不确定
            /*
                比如 数组1：1 2 5 6
                     数组2：3 4
                i=2指向5，j=0指向3时,count=3 == median ，但中位数是3和4
            */

            //分情况，奇数和偶数
            if(sumLength%2==0){
                //偶数情况下，需要两个元素，所以记录一下
                if(count == median-1){
                    pre = Math.min(nums1[i],nums2[j]);
                }
                if(count == median) {
                    res = (Math.min(nums1[i],nums2[j])+pre)/2.0;
                    break;
                }
            }else{  //奇
                if(count == median) {
                    res = (Math.min(nums1[i],nums2[j]))/1.0;
                    break;
                }
            }

        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        int sumLength = nums1.length + nums2.length;
        int median = sumLength/2;
        int[] arr = new int[sumLength];
        System.arraycopy(nums1,0,arr,0,nums1.length);
        System.arraycopy(nums2,0,arr,nums1.length-1,nums2.length);
        Arrays.sort(arr);
        if(sumLength%2==0) System.out.println((arr[median-1] + arr[median])/2.0);
        else System.out.println(arr[median]/1.0);
    }
}
