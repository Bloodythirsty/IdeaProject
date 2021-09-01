package _0828小马;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author zhangkangkang
 * @date 2021/08/28 15:37
 */
public class test2 {


    // 全局遍历
    private static int result;
    //四个边
    private static List<Integer> top = new ArrayList<>();
    private static List<Integer> down = new ArrayList<>();
    private static List<Integer> left = new ArrayList<>();
    private static List<Integer> right = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        List<Integer> xIndex = new ArrayList<>();
        List<Integer> yIndex = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            xIndex.add(sc.nextInt());
            yIndex.add(sc.nextInt());
        }
        for (int i = 0; i < m; i++) {
            int x = xIndex.get(i);
            int y = yIndex.get(i);
            if (x == 0){
                left.add(y);
            }else if (y == 0){
                down.add(x);
            }else if (x == n){
                right.add(y);
            }else {
                top.add(x);
            }
        }
        Collections.sort(top);
        Collections.sort(down);
        Collections.sort(right);
        Collections.sort(left);

        for (int i = 0; i < m; i++) {
            lookLeft(i,xIndex,yIndex);
            lookRight(i,xIndex,yIndex);
        }

        System.out.println(result);
    }

    private static void lookRight(int i, List<Integer> xIndex, List<Integer> yIndex) {

    }

    private static void lookLeft(int i, List<Integer> xIndex, List<Integer> yIndex) {

    }
}
