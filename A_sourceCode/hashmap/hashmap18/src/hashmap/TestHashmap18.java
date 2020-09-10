package hashmap;

import java.util.HashMap;
import java.util.Map;

public class TestHashmap18 {
    public static void main(String[] args) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(1,2);
        Integer oldValue = map.put(1, 3);
        System.out.println("oldValue = " + oldValue);

        Integer I = new Integer("2323");
    }
}
