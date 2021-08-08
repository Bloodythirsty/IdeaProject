package _0808meituan;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author zhangkangkang
 * @date 2021/08/08 10:43
 */
public class Meituan2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String source = sc.nextLine();
        LinkedList<Character> deque = new LinkedList<>();
        for(int i=0;i<source.length();i++){
            char curr = source.charAt(i);
            if(curr == ' '){
                continue;
            }
            if(deque.isEmpty() || deque.peekLast() != curr){
                deque.addLast(curr);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Character character : deque) {
            sb.append(character);
        }
        System.out.println(sb);
    }
}
