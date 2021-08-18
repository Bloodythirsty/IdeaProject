import java.util.*;

public class TestPriorityQueue {
    public static void main(String[] args) {
        // Queue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(a -> a));
        // heap.add(5);
        // heap.add(4);
        // heap.add(3);
        // heap.add(2);
        //
        //
        // System.out.println(heap.poll());
        // System.out.println(heap.poll());
        // System.out.println(heap.poll());
        // System.out.println(heap.poll());
        int n = 4;
        int[][] edges= new int[3][2];
        edges[0][0] = 1;
        edges[0][1] = 0;
        edges[1][0] = 1;
        edges[1][1] = 2;
        edges[2][0] = 1;
        edges[2][1] = 3;
        findMinHeightTrees(n,edges);
    }

    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if(n==1){
            res.add(0);
            return res;
        }

        // 邻接表和无向图得入度表
        List<List<Integer>> adjaency = new ArrayList<>();
        int[] degrees = new int[n];
        for(int i=0;i<n;i++) adjaency.add(new ArrayList<>());
        for(int[] pre:edges){
            degrees[pre[0]]++;
            degrees[pre[1]]++;
            adjaency.get(pre[0]).add(pre[1]);
            adjaency.get(pre[1]).add(pre[0]);
        }

        Deque<Integer> queue = new ArrayDeque<>();
        // 把度为1得放进去，层层剥离
        for(int i=0;i<n;i++){
            if(degrees[i]==1) queue.add(degrees[i]);
        }

        while(!queue.isEmpty()){
            res.clear();
            int size = queue.size();
            for(int i=0;i<size;i++){
                int temp = queue.poll();
                res.add(temp);
                for(int cur:adjaency.get(temp)){
                    if(--degrees[cur] == 1) queue.add(cur);
                }
            }

        }
        return res;
    }

}
