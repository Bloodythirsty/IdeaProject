package _0831美团;

/**
 * @author zhangkangkang
 * @date 2021/08/31 13:31
 */

/*

A的B次方根


https://blog.csdn.net/renwotao2009/article/details/52909363
 */



public class MeiTuan1 {
    public static void main(String[] args) {
        System.out.println(handle(5,5));
    }

    public static double handle(double a, double b){
        double exp = 0.000001;
        while (Math.abs(b-1) > exp){
            a = Math.sqrt(a);
            b = b/2;
        }
        return a;
    }
}
