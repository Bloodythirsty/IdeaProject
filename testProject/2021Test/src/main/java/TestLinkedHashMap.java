import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TestLinkedHashMap {
    public static void main(String[] args) {
        // Map<String,String> map = new LinkedHashMap<>(16, 0.75f, true);
        // map.put("k1","v1");
        // map.put("k2","v2");
        // for (Map.Entry<String, String> entry : map.entrySet()) {
        //     System.out.println(entry.getKey() +" + "+entry.getValue());
        // }
        // System.out.println("==========================");
        // map.put("k1","v111");
        // for (Map.Entry<String, String> entry : map.entrySet()) {
        //     System.out.println(entry.getKey() +" + "+entry.getValue());
        // }
        //
        // System.out.println("==========================");
        // map.get("k2");
        // for (Map.Entry<String, String> entry : map.entrySet()) {
        //     System.out.println(entry.getKey() +" + "+entry.getValue());
        // }
        //
        // int[] arr = {3,30,25,4};
        // IntStream.of(arr).sum();
        // // String collect = IntStream.of(arr).mapToObj(String::valueOf)
        // //         .sorted((a, b) -> (a + b).compareTo(b + a))
        // //         .collect(Collectors.joining());
        // // System.out.println("collect = " + collect);
        // int[] ints = Arrays.copyOfRange(arr, 0, 2);
        // for (int anInt : ints) {
        //     System.out.println("anInt = " + anInt);
        // }

        Map<Integer,Integer> map = new HashMap<>();
        map.put(1,2);
    }
}
