import java.util.HashMap;
import java.util.Map;

public class Test1 {
    public static void main(String[] args) {
        int[][] arr = {{1,2,3},{4,5,6},{7,8,9}};
        reverse(arr);
        for (int i = 0; i < arr.length; i++) {
            for (int i1 = 0; i1 < arr.length; i1++) {
                System.out.print(arr[i][i1] + " ");
            }
            System.out.println();
        }
    }

    private static void reverse(int[][] arr) {
        int N = arr.length;
        for(int i=0;i<N;i++){
            for(int j=i;j<N;j++){
                int tmep = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = tmep;
            }
        }
    }
}

/*
类
 */
class Retangle{
    private int rowNum;
    private int colNum;

    private Map<Integer, Map<Integer,Integer>> nums;

    public Retangle(int[][] arr){
        this.rowNum = arr.length;
        this.colNum = arr[0].length;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                Map<Integer, Integer> map = nums.getOrDefault(i, new HashMap<>());
                map.putIfAbsent(j,arr[i][j]);
            }
        }
    }

    public int getValue(int i, int j){
        if(i >= rowNum || j >= colNum ||  i < 0 || j < 0){
            return Integer.MIN_VALUE;
        }
        return nums.get(i).get(j);
    }

    public void reverse(){

    }
}
