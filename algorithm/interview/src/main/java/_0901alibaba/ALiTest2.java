package _0901alibaba;

import java.util.*;

public class ALiTest2 {
    public static void main(String[] args) {

        String name1 = "Alice",name2 = "Bob";
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int N = sc.nextInt(), M = sc.nextInt();
            int[][] digrams = new int[N][N];
            for (int j = 0; j < M; j++) {
                int x = sc.nextInt(), y = sc.nextInt();
                digrams[x - 1][y - 1] = 1;
            }
            String firstName = sc.next();
            Deque<Integer> path = new ArrayDeque<>();
            List<List<Integer>> result = new ArrayList<>();
            trace(path, result, digrams, 0);
            int size = result.stream().max(Comparator.comparingInt(List::size)).get().size();
            if(size%2==1){
                System.out.println(firstName);
            }else{
                System.out.println(firstName.equals(name1) ? name2 : name1);
            }
        }
    }

    private static void trace(Deque<Integer> path, List<List<Integer>> result, int[][] digrams, int beginIndex) {
        if (beginIndex == digrams.length - 1) {
            path.add(digrams.length - 1);
            result.add(new ArrayList<>(path));
            path.removeLast();
            return;
        }
        path.add(beginIndex);
        for (int i = 0; i < digrams.length; i++) {
            if (digrams[beginIndex][i] == 1){
                trace(path, result, digrams, i);
            }
        }
        path.removeLast();
    }
}


/*

图走路径，谁走到最后一步，谁赢

1
5 6
1 2
1 3
2 3
2 4
3 5
4 5
Alice

1
3 3
1 2
2 3
3 2
Alice

 */