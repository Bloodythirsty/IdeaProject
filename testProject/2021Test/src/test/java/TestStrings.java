import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by kangkang on 2021/3/29 19:14
 */
public class TestStrings {

    @Test
    public void testStringBuilder(){
        StringBuilder sb = new StringBuilder("zhangkangkang");
        sb.delete(0,5);
        sb.append(55555);
        System.out.println("sb.toString() = " + sb.toString());
    }

    @Test
    public void testString1(){
        String s = "zhangkangkang";
        String substring = s.substring(0, s.length());
        System.out.println("substring = " + substring);
    }

    @Test
    public void testString12(){
        int[] arr = {1,2,3,4};
        Set<Set<Integer>>  sets = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        for(int i:arr){
            if(set.contains(i)){
                sets.add(set);
                set = new HashSet<>();
            }
            set.add(i);
        }
        sets.add(set);
        int max = 0;
        for(Set<Integer> s:sets){
            max = Math.max(max,s.size());
        }
        System.out.println("max = " + max);
    }

    @Test
    public void testRadix(){
        System.out.println(Integer.parseInt("AA",16));
    }
}
