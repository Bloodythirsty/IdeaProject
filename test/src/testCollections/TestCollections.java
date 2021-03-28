package testCollections;

import org.junit.Test;

import java.util.*;

public class TestCollections {

    @Test
    public  void testMap() {
        Map<Man,String> map = new HashMap<>();
        map.put(new Man("zkk",111),"first");
        map.put(new Man("zkk",111),"second");
        Set<Man> men = map.keySet();
        for (Man man : men) {
            System.out.println("man = " + man);
            System.out.println(map.get(man));
        }
    }

    @Test
    public void testSet() {
        Set<Man> set = new HashSet<>();
        set.add(new Man("zkk",111));
        set.add(new Man("zkk",111));

        Iterator<Man> iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println("iterator.next() = " + iterator.next());
        }

    }

    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        String put = map.put("1", "2");
        System.out.println((int)1.8);
    }

    @Test
    public void testArray() {
        int[] as = {9,1,5,4,33,4,5,7,-1};
        Integer[] asI = new Integer[as.length];
        for (int i = 0; i < as.length; i++) {
            asI[i]=as[i];
        }
        Arrays.sort(asI, (o1, o2) -> o2-o1);
        for (int a : asI) {
            System.out.print("   "+a);
        }
    }


}


