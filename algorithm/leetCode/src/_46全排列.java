import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _46全排列 {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        permute(arr);
    }
    static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        for(int num:nums){
            output.add(num);
        }

        int n = nums.length;
        traceBack(n,output,res,0);
        return res;
    }

    static void traceBack(int n, List<Integer> output, List<List<Integer>> res , int first){
        if(first == n){
            res.add(new ArrayList<>(output));
        }

        for(int i=first;i<n;i++){
            Collections.swap(output,first,i);
            traceBack(n,output,res,first+1);
            Collections.swap(output,first,i);
        }
    }
}
