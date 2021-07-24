import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class testLit {

    @Test
    public void testLinkedList(){
        LinkedList<Integer> list = new LinkedList<>();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        for (Integer integer : list) {
            System.out.println("integer = " + integer);
        }
        list.remove(2);
        for (Integer integer : list) {
            System.out.println("integer = " + integer);
        }

    }

    @Test
    public  void testList(){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(4);
        list.add(3);
        list.add(6);
        list.sort((x,y)->y-x);
        list.forEach(System.out::println);

        char[] chars = new char[5];
        Arrays.fill(chars,'0');
        for (char aChar : chars) {
            System.out.println("aChar = " + aChar);
        }

        boolean[] booleans = new boolean[5];
        for (boolean aBoolean : booleans) {
            System.out.println("aBoolean = " + aBoolean);
        }
    }
}
