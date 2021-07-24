import java.util.ArrayList;
import java.util.List;

public class NumCourses {
    public static void main(String[] args) {
        int[][] prerequisites = new int[1][2];
        prerequisites[0][0] = 0;
        prerequisites[0][1] = 1;
        int numCourses = 2;
        canFinish(numCourses,prerequisites);
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] pre:prerequisites){
            adj.get(pre[1]).add(pre[0]);
        }
        int[] visited = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            if(!dfs(adj,visited,i)) return false;
        }
        return true;
    }

    public static boolean dfs(List<List<Integer>> adj, int[] visited, int i){
        if(visited[i]==1) return false;
        visited[i] = 1;
        for(Integer j:adj.get(i)){
            if(!dfs(adj,visited,j)) {
                visited[i]=0;
                return false;
            }
        }
        visited[i]=0;
        return true;
    }
}
