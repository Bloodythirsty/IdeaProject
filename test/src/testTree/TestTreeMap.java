package testTree;

import java.util.Map;
import java.util.TreeMap;

public class TestTreeMap {
    public static void main(String[] args) {
        TreeMap<Integer,String> map = new TreeMap<>();
        // int i = 5;
        // int j = 0x80000000;
        // int j1 = 0x7FFFFFFF;
        // System.out.println(i<<1);
        // System.out.println(j);
        // System.out.println("j1 = " + j1);
        map.put(1,"1");
        map.put(2,"2");
        map.put(-1,"-1");
        map.put(100,"100");
        map.put(-201,"-201");
        map.put(3,"3");
        map.put(3,"31");

        for (Integer integer : map.keySet()) {
            System.out.println("integer = " + integer);
        }

        for (Integer integer : map.descendingKeySet()) {
            System.out.println("set = " + integer);
        }

    }
}
