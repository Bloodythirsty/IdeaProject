package _0903beike;

import java.util.*;

public class BeikeTest3 {

    private static int maxResult = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int m = sc.nextInt();
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        Collections.sort(list);
        count(list, n-1,n-2,k,m,list.removeLast());
        System.out.println(maxResult);
    }

    private static void count(LinkedList<Integer> list, int n,int i, int k, int m,int currMax) {
        if (n < 0) return;
        if (n == 0){
            maxResult = Math.max(currMax,maxResult);
            return;
        }

        for (int j = 0; j <= k && i >= j; j++) {
            int currIndex = i-j;
            Integer temp = list.get(currIndex);
            list.remove(currIndex);
            if ( temp > m){
                count(list, n-3,i-1, k, m, currMax+temp);
            }else {
                count(list, n-1,i-1, k, m, currMax+temp);
            }
            list.add(currIndex,temp);
        }

    }
}


/*


5 2 10
5 8 10 15 33

 */