package _0903beike;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BeikeTest4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int minSplitLength = 0;
        List<List<Integer>> arr = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int nSplit = sc.nextInt();
            minSplitLength = Math.min(minSplitLength,nSplit);
            ArrayList<Integer> currSplit = new ArrayList<>();
            for (int j = 0; j < nSplit; j++) {
                currSplit.add(sc.nextInt());
                currSplit.add(sc.nextInt());
            }
            arr.add(currSplit);
        }


    }
}


/*

3 5
3
1 2
3 4
5 5
2
1 2
3 5
2
1 3
4 5

 */