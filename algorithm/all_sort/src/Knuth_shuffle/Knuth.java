package Knuth_shuffle;

import java.util.Arrays;
import java.util.Random;

/*
洗牌算法：
    1. 要求：公平，从1-100个数字中抽出50个不重复的数字。
    2. 分析:
            1. n个元素有n!种排列。从中抽出1种即可
            2. 可以先公平地打乱数组，再顺序取出50个即可
            3. 怎么打乱？
                从未选中的元素中随机选中一个，再与最后一个未操作的元素交换
                本元素可以与自己交换
                最后一个元素可以不用操作。
 */
public class Knuth {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(Arrays.toString(arr));
        Shuffle(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static  void Shuffle(int[] arr){
        Random random = new Random();
        for (int i = arr.length ; i > 0 ; i--){     // 0 不用产生了
            int ran = random.nextInt(i);
            int temp = arr[ran];              //产生 0~i-1
            arr[ran] = arr[i-1];
            arr[i-1] = temp;
        }
    }
}
