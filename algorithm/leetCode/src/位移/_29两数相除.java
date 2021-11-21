package 位移;

/**
 * @author zhangkangkang
 * @date 2021/11/08 10:35
 */
public class _29两数相除 {
    public static void main(String[] args) {
        test(-2147483648,1);
    }

    private static int test(int dividend, int divisor){
        if(divisor == 0) return Integer.MAX_VALUE;
        // 针对结果溢出
        if(dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        int sign = (dividend ^ divisor) < 0 ? -1 :1 ;

        long ed = (Math.abs((long)dividend));
        long or = (Math.abs((long)divisor));
        int result = 0;
        for(int i=31;i>=0;i--){
            if((ed >> i) >= or){
                result += 1 << i;
                ed -= or << i;
            }
        }
        return sign < 0 ? -result : result;
    }
}
