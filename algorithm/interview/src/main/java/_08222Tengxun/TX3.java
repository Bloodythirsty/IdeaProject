package _08222Tengxun;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author zhangkangkang
 * @date 2021/08/22 21:38
 */
public class TX3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        String source = sc.next();
        if (n == k){
            System.out.println(source);
        }

        String result = "";
        int begin = 0, end = n-k;
        for (int i = 0; i < k; i++) {
            if(begin == end){
                result = result + source.substring(begin);
                break;
            }
            LinkedList<Integer> stack = new LinkedList<>();
            for (int j = begin; j <= end; j++) {
                while (!stack.isEmpty() && source.charAt(stack.peekLast()) < source.charAt(j)){
                    stack.pollLast();
                }
                stack.add(j);
            }
            result = result + source.charAt(stack.peekFirst());

            begin = stack.peekFirst()+1;
            end ++;
        }
        System.out.println(result);
    }
}


/*

4 2
ebfc

fc


10 7
yicfihpfbz

yiipfbz

10 5
abcdefghij

10 2
abcdefghij
 */