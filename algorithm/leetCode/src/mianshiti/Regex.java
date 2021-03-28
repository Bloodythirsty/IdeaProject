package mianshiti;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {

    @Test
    public void test(){
        String str1 = " 1  +  2/ 35*2 ";
        String[] split = str1.split("[0-9]");
        for (String s : split) {
            System.out.println("s = " + s);
        }
    }

    @Test
    public void test_1(){
        String str1 = " 1+2/ 35*2 ";
        String[] split = str1.split("\\+|-|\\*|/");
        for (String s : split) {
            System.out.println("s = " + s);
            System.out.println(Integer.parseInt(s.trim()));
        }
    }

    //  提取字符串的数字
    @Test
    public void testPattern(){
        String a="love23next234csdn3423javaeye";
        String b = "42/5+5";
        String reg = "[^0-9]";
        Pattern p = Pattern.compile(reg);       // 返回pattern
        System.out.println("p.toString() = " + p.toString());
        Matcher matcher = p.matcher(a);         //matcher包含了匹配到的字符串
        System.out.println("matcher.toString() = " + matcher.toString());
        //把匹配到的字符串替换！
        String s = matcher.replaceAll(" ");
        System.out.println(s);

        //
        String[] s1 = s.split(" ");
        for (String s2 : s1) {
            System.out.println("s2 = " + s2);
        }

        String s2 = "s";
        System.out.println(s2.charAt(0));


    }

    //  提取字符串的符号
    @Test
    public void testPattern_1(){
        String c = "   42   +2/3*5";
        String reg = "[0-9]";
        Pattern p = Pattern.compile(reg);       // 返回pattern
        System.out.println("p.toString() = " + p.toString());
        Matcher matcher = p.matcher(c);         //matcher包含了匹配到的字符串
        System.out.println("matcher.toString() = " + matcher.toString());
        //把匹配到的字符串替换！
        String s = matcher.replaceAll(" ");
        System.out.println(s);
        String[] s1 = s.split(" ");
        System.out.println(s1.length);
        for (String s2 : s1) {
            System.out.println(s2.length());
            System.out.println("s2 = " + s2);
        }



    }

    @Test
    public void testTrim(){
        String s = "  ";
        System.out.println(s.length());
        System.out.println(s.trim().length());
    }
}
