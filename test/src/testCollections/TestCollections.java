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
}


