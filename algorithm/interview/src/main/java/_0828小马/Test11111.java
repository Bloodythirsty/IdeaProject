package _0828小马;

import java.util.Scanner;

/**
 * @author zhangkangkang
 * @date 2021/08/28 15:30
 */
public class Test11111 {
    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            long E = sc.nextLong();
            long EM = sc.nextLong();
            long M = sc.nextLong();
            long MH =sc.nextLong();
            long H = sc.nextLong();
            long lo = 0;
            long hi = (E+EM+H+M+MH)/3;
            while(lo <= hi){
                long mid = (lo+hi)/2;
                if(check(E,EM,M,MH,H,mid)){
                    lo = mid+1;
                }
                else{
                    hi = mid-1;
                }
            }
            System.out.println(hi);
    }

    public static boolean check(Long a,Long b,Long c,Long d,Long e,Long num){
        if(a+b<num){
            return false;
        }
        else if(d+e < num){
            return false;
        }
        else if(b+c+d<num){
            return false;
        }
        return true;
    }
}

/*

657 657 657 657 657
 */
