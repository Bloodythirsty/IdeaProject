package _0918wangyi;


/**
 * @author zhangkangkang
 * @date 2021/09/18 19:10
 */
public class WangyiTest1 {

    public static void main(String[] args) {
//        long s = 10000000000000000L;
        long s = 17;
        long max = tableSizeForMax(s);
        long min = tableSizeForMin(s);
        long leftHeigh = s - min;
        long rightHeigh = max - s;
        // 取最小的
        long result=1,restValue=0;
        if (rightHeigh >= leftHeigh){
            restValue = leftHeigh;
        }else {
            restValue = rightHeigh;
        }
        result += countOne(restValue);
        System.out.println(result);

    }

    // 计算二进制中1的个数
    private static int countOne(long restValue) {
        int count = 0;
        for (int i = 0; i < 64; i++) {
            if (((restValue >> i) & 1) == 1){
                count++;
            }
        }
        return count;
    }

    static long tableSizeForMax(long cap) {
        long n = cap - 1;
        // 右移后，进行或操作
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        n |= n >>> 32;
        return  n + 1;
    }

    static long tableSizeForMin(long cap) {
        long n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        n |= n >>> 32;
        return n - (n >> 1);
    }
}

/*

用多少个2的幂计算出s

只能全加或者全减

30  : 32 - 2  两个2的幂数

17  ： 16 + 1 两个2的幂数



 */
