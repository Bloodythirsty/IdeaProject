package _08222Tengxun;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author zhangkangkang
 * @date 2021/08/22 19:57
 */
public class TengX1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TEMP = 1000000007;
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int numCount = sc.nextInt();
            PriorityQueue<Integer> heap = new PriorityQueue<>((e1,e2)->e2-e1);
            for (int i1 = 0; i1 < numCount; i1++) {
                heap.add(sc.nextInt());
            }
            int result = 0 , base = 0;
            for (int i1 = 0; i1 < numCount; i1++) {
                int currNum = heap.poll();
                result = result + currNum + (currNum + base) * heap.size();
                base += currNum;
                result %= TEMP;
            }
            System.out.println(result);
        }
    }
}

/*


3
5
80 90 88 70 40
2
1 2
3
1 2 3
 */
