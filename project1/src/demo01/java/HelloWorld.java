package demo01.java;


import java.util.ArrayList;
import java.util.List;

public class HelloWorld {
    public static void main(String[] args){
        System.out.println("hellro");
        List list =  new ArrayList();   //这是一个注释
        test();
        List list1 = new ArrayList();
        System.out.println("args = [" + args + "]");



    }



    public static void test( ){
        System.out.println("hjj");
        System.out.print("a ");
    }
}
