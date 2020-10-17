import org.junit.Test;
import pojo.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

public class testTypeOfPackaging {
    public static void main(String[] args) {
        /*
                java的8种基本包装类没有提供改变值的方法，只能新建
         */
        Integer a = 1;
        Integer b = a;      //此时ab同一地址
        b++;                //b新建了
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("a.getClass() = " + a.getClass());
        System.out.println("b.getClass() = " + b.getClass());
    }

    @Test
    public void testLine() throws IOException {
        System.out.println("ab\ncdwfr\nooo\n\n");
        System.out.println("----------------------------");
        System.out.println("ab\r\ncdwfr\r\nooo\r\n\r\n");
        BufferedReader in = new BufferedReader(new StringReader("ab\ncd\nefg\n\n"));
        String s = null;
        StringBuilder sb = new StringBuilder();
        while ((s = in.readLine()) != null){
            sb.append(s+"#");
        }
        System.out.println(sb);

        char c = 'A';
        int a = (int)c + 32;
        System.out.println((char)a);
        System.out.println();
    }

    @Test
    public void name() {
        String s = "abc";
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            StringBuilder stringBuilder = new StringBuilder();
            short s1  = 20;
            byte b = 21;
            stringBuilder.append(s);
            stringBuilder.append(b);

            User user = new User();
            System.out.println(user==null);
            System.out.println(user.classesInfo == null);
        }
    }
}



