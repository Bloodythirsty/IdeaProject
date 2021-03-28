package niuKe;

import org.junit.Test;

import java.util.ArrayDeque;

public class 括号匹配 {

    public static void main(String[] args) {
        String s= "()[]{]}";
        boolean valid = isValid(s);
        System.out.println("valid = " + valid);
    }

    public static boolean isValid(String s){
        ArrayDeque<Character> que = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (que.isEmpty()){
                que.addFirst(s.charAt(i));
            }else{
                if (s.charAt(i)==')' && que.peekFirst()=='(') que.removeFirst();
                else if (s.charAt(i)==']' && que.peekFirst()=='[') que.removeFirst();
                else if (s.charAt(i)=='}' && que.peekFirst()=='{') que.removeFirst();
                else    que.addFirst(s.charAt(i));
            }
        }
        return que.isEmpty();
    }
}
