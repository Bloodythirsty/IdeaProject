import java.util.ArrayDeque;

public class TestSwitch {
    public static void main(String[] args) {
        String s  = "{[()]}}";
        boolean valid = isValid(s);
        System.out.println("valid = " + valid);
    }

    private static boolean isValid(String s) {
        ArrayDeque<Character> que = new ArrayDeque<>();
        int i = 0;
        for (; i < s.length(); i++) {
            if (que.isEmpty()){
                que.addFirst(s.charAt(i));
            }else{
                if (s.charAt(i) == ')' && que.peekFirst()=='(') que.removeFirst();
                else if(s.charAt(i) == ']' && que.peekFirst()=='[') que.removeFirst();
                else if (s.charAt(i) == '}' && que.peekFirst()=='{') que.removeFirst();
                else que.addFirst(s.charAt(i));
            }
        }
        return que.isEmpty();
    }
}
