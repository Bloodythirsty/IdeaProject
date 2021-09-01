package hulu;

import java.util.Scanner;

public class HuluTest3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = sc.nextInt();
        long long1 = sc.nextLong();
        long long2 = sc.nextLong();
        int result = 0;
        for (long i = long1; i <= long2 ; i++) {
            if(sumT(i) == sum){
                result++;
            }
        }
        System.out.println(result);
    }

    private static int sumT(long i) {
        int sum = 0;
        while (i != 0){
            sum += i%10;
            i /= 10;
        }
        return sum;
    }
}
