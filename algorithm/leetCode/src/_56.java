import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class _56 {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        merge(arr);
    }

    private static int[][] merge(int[][] arr){
        PriorityQueue<int[]> queue = new PriorityQueue<>(
                Comparator.comparingInt(e -> e[0])
        );

        queue.addAll(Arrays.asList(arr));


        while (!queue.isEmpty()){
            int[] poll = queue.poll();
            System.out.println(poll[0]);
        }

        return arr;
    }
}
