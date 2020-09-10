package demo01.classs;

public class TestClass {
    public static void main(String[] args) {
        String a = "";
        System.out.println(a.getClass());               //class java.lang.String
        System.out.println(a.getClass().getClass());    //Class的getClass就是Class：class java.lang.Class
        System.out.println(a.getClass().getName());    //Class的名字：java.lang.String
    }
}
