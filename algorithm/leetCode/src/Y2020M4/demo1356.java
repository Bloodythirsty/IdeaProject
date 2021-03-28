package Y2020M4;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class demo1356 {
    public int[] sortByBits(int[] arr) {
        ArrayList[] lists = new ArrayList[33];
        Arrays.fill(lists,new ArrayList<Integer>());
        for(int key:arr){
            int sum_1 =0;
            for(int i=0; i<32 ; i++){
                if(((key>>i) & 1) == 1){
                    sum_1++;
                }
            }
            lists[sum_1].add(key);
        }
        for(ArrayList list:lists){
            Collections.sort(list);
        }
        int i=0;
        for(ArrayList list:lists){
            for(Object key:list){
                arr[i++]=(Integer)key;
            }
        }
        return arr;
    }

    @Test
    public void test(){
        int[] a = {0,1,2,3,4,5,6,7,8};
        sortByBits(a);
    }
}
