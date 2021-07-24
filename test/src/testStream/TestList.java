package testStream;

import testCollections.Man;

import java.util.*;
import java.util.stream.Collectors;

public class TestList {
    public static void main(String[] args) {
        Man zhangsan = new Man("zhangsan", 10);
        Man zhangsan1 = new Man("zhangsan1", 101);
        Man zhangsan12 = new Man("zhangsan12", 1012);

        ArrayList<Man> integers = new ArrayList<Man>();
        integers.add(zhangsan);
        integers.add(zhangsan1);
        integers.add(zhangsan12);

        List<Integer> collect = integers.stream().map(e -> e.getAge()).collect(Collectors.toList());
        for (int i = 0; i < collect.size(); i++) {
            System.out.println("i = " + i);
        }

        Map<int[],String> map = new HashMap<>();
        int[] ints = {1, 2};
        map.put(ints,"hah");
        Set<Map.Entry<int[], String>> entries = map.entrySet();
        for (Map.Entry<int[], String> entry : entries) {
            int[] key = entry.getKey();
            for (int i : key) {
                System.out.println(i);
            }
            System.out.println(entry.getValue());
        }
    }
}
