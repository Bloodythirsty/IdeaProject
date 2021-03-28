import org.junit.Test;

import java.util.Deque;
import java.util.regex.Pattern;

public class testRegex {

    @Test
    public void test(){
        String pattern1 = "^\\w{5,8}@\\w+\\.\\w+";
        String email1 = "9398556@qq.com";

        System.out.println("Pattern.matches(pattern, email1) = " + Pattern.matches(pattern1, email1));

        String pattern2 = "^\\w{5,8}@\\w+.\\w+";
        String email2 = "9398556@qq" +
                "com";
        System.out.println(Pattern.matches(pattern2,email2));

        Integer integer1 = new Integer("5");
        int i = integer1;

        Character c = 'a';
        char c1 = c;

    }
}
