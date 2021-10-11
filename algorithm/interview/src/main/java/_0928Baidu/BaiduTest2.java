package _0928Baidu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author zhangkangkang
 * @date 2021/09/28 19:43
 */
public class BaiduTest2 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int T = sc.nextInt();
//        for (int i = 0; i < T; i++) {
//            int n = sc.nextInt(), subN = sc.nextInt();
//            int[] nums = new int[n];
//            for (int j = 0; j < n; j++) {
//                nums[j]=sc.nextInt();
//            }
//            ArrayList<ArrayList<Integer>> allSort = getAllSort(nums, subN);
////            List<ArrayList<Integer>> collect = allSort.stream().filter(e -> e.size() == subN).collect(Collectors.toList());
//            int result = 0;
//            for (ArrayList<Integer> integers : allSort) {
//                Integer r = integers.stream().reduce(Integer::sum).get();
//                if ((r & 1)==0) result++;
//            }
//            System.out.println(result % 1000000007);
//        }

        int[] nums = {1,2,3,4};
        getAllSort(nums,10);

//        int s = 1 << 50;
//        System.out.println(s);
    }



    public static ArrayList<ArrayList<Integer>> getAllSort(int[] nums,int subN){
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int mark = 0;
        int nEnd = 1 << nums.length;
//        boolean bNullSet = false;
        for (mark = 0;mark < nEnd ; mark++){
            ArrayList<Integer> list = new ArrayList<>();
//            bNullSet = true;
            for (int i = 0; i < nums.length; i++) {
                if(((1<<i)&mark)!=0){
//                    bNullSet = false;
                    list.add(nums[i]);
                }
            }
            if (list.size() == subN){
                result.add(list);
            }
        }
        return result;
    }
}
