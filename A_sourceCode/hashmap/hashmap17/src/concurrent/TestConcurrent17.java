package concurrent;

import java.util.concurrent.ConcurrentHashMap;

public class TestConcurrent17 {
    public static void main(String[] args) {
        ConcurrentHashMap<String,String> hashMap =
                new ConcurrentHashMap<>(45, (float) 0.75d, 7);
        hashMap.put("a","1");

        //测试 & 与 &&
        // & : 不管前面条件真假，会继续执行后面条件
        // &&: 只要前面条件为false，后面不会执行
        int i = 0;
        int j = 0;
        if ( i != 0 & (++j ==1) ){
            System.out.println("jinqule");
        }
        System.out.println("j = " + j);
    }
}
