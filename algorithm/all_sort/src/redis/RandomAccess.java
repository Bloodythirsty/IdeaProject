package redis;

import org.junit.Test;

public class RandomAccess {
    // 该 randomLevel 方法会随机生成 1~MAX_LEVEL 之间的数，且 ：
//        1/2 的概率返回 1
//        1/4 的概率返回 2
//        1/8 的概率返回 3 以此类推
    float SKIPLIST_P = 0.5f;
    int MAX_LEVEL = 5;

    private int randomLevel() {
        int level = 1;
        // 当 level < MAX_LEVEL，且随机数小于设定的晋升概率时，level   1
        while (Math.random() < SKIPLIST_P && level < MAX_LEVEL)
            level += 1;
        return level;
    }

    @Test
    public void test1(){
        int[] ints = new int[10000];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = randomLevel();
        }
        int ones = 0;
        int twos = 0;
        int threes = 0;
        int fours = 0;
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] == 1) ones++;
            if (ints[i] == 2) twos++;
            if (ints[i] == 3) threes++;
            if (ints[i] == 4) fours++;
        }
        System.out.println((float)ones/ints.length);
        System.out.println((float)twos/ints.length);
        System.out.println((float)threes/ints.length);
        System.out.println((float)fours/ints.length);
    }


    // 该 randomLevel 方法会随机生成 1~MAX_LEVEL 之间的数，且 ：
//        1/3 的概率返回 1
//        1/9 的概率返回 2
//        1/27 的概率返回 3 以此类推
    float SKIPLIST_P_2 = 2/3f;
    int MAX_LEVEL_2 = 4;

    private int randomLevel2() {
        int level = 1;
        int ran = 1;
        // 当 level < MAX_LEVEL，且随机数小于设定的晋升概率时，level   1
        while (Math.random() < SKIPLIST_P_2 && ran%3==0 && level < MAX_LEVEL_2){
            level += 1;
            ran++;
        }
        return level;
    }
}
