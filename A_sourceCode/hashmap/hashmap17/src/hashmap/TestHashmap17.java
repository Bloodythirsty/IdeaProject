package hashmap;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class TestHashmap17 {
    public static void main(String[] args) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(1,2);
        Integer oldValue = map.put(1, 3);
        map.put(4,null);
        map.put(null, 0);
        Integer put1 = map.put(null, null);
        System.out.println("put1 = " + put1);

        System.out.println("oldValue = " + oldValue);

        //抑制警告
        @SuppressWarnings("unused")
        Integer I = new Integer("2323");

       // Hashtable<Object, Object> objectObjectHashtable = new Hashtable<>();
    }
}
