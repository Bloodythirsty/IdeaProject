package concurrent;

import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class TestConcurrent18 {
    public static void main(String[] args) {
        ConcurrentHashMap<String,String> hashMap = new ConcurrentHashMap<>();
        hashMap.put("a","1");

        //ThreadLocalRandom.getProbe()

        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            System.out.println(random.nextInt(10));
        }

        System.out.println(Runtime.getRuntime().availableProcessors());

        System.out.println("==================");

        System.out.println(Integer.numberOfLeadingZeros(16) | (1 << (16 - 1)));
    }
}
