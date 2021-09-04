package _0903beike;

import java.util.LinkedList;
import java.util.Scanner;

public class BeikeTest2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            String s = sc.next();
            countNum(N,s);
        }
    }

    private static void countNum(int n,String s) {
        LinkedList<Character> leftStack = new LinkedList<>();
        LinkedList<Character> rightStack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if(curr == '('){
                leftStack.push(curr);
            }else{
                if(!leftStack.isEmpty()){
                    leftStack.pop();
                }else {
                    rightStack.push(curr);
                }
            }
        }
        System.out.println(leftStack.size());
    }
}


/*

3
6
()()()
6
)))(((
18
))(((())()()()())(

 */
