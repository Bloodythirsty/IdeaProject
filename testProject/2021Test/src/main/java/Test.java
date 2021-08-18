import afu.org.checkerframework.checker.igj.qual.I;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        // int[] arrs = {0,1,3,50,75};
        // int[] arrs = {3,4,5,50,75,99};
        // int[] arrs = {0};
        // int lowLimit = 0;
        // int hightLimit = 99;

        // handle(arrs,lowLimit,hightLimit);
        // System.out.println(Integer.MIN_VALUE);
        // System.out.println(Integer.MAX_VALUE);
        //
        // HashMap[] rows = new HashMap[9];
        // rows[0] = new HashMap<Integer, Integer>();

        // int s = -3;
        // System.out.println((1<<31));
        //
        // int[][] doubleArray = new int[][]{{1,2},{3,4}};
        //
        // Map<Integer,String> map = new HashMap<Integer,String>(){{
        //     put(1,"kk");
        //     put(2,"kk");
        // }};
        System.out.println("\"hah \"");
    }

    // 张康康   2021/4/7
    private static void handle(int[] arrs, int lowLimit, int hightLimit) {
        if(arrs.length==0) return;
        List<String> result = new ArrayList<>();
        if (arrs[0]!=lowLimit){
            int gap = arrs[0] - lowLimit;
            if (gap == 1){
                result.add(lowLimit+"");
            }else{
                int pre = arrs[0]-1;
                result.add(lowLimit+"->"+pre);
            }
        }
        for (int i = 1; i < arrs.length; i++) {
            int gap = arrs[i] - arrs[i-1];
            if (gap == 2){
                int re = arrs[i]-1;
                result.add(re+"");
            }else if (gap > 2){
                int re1 = arrs[i-1]+1;
                int re2 = arrs[i]-1;
                result.add(re1+"->"+re2);
            }
        }
        if (arrs[arrs.length-1] != hightLimit){
            int gap = hightLimit - arrs[arrs.length-1];
            if (gap == 1){
                result.add(hightLimit+"");
            }else{
                int pre = arrs[arrs.length-1]+1;
                result.add(pre+"->"+hightLimit);
            }
        }

        for (String s : result) {
            System.out.println(s);
        }
    }



}
