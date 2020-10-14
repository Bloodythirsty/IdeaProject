public class Test_面试笔试_静态代码块 {


    public static void testFather(A a){
        a.out();
    }


    public static void main(String[] args) {
        C c = new C();
        c.out();
        testFather(c);
    }
}



 class A {
    static int i = 5;
    static int j = 5;
    static C c1 = new C();
    {
        System.out.println("A1");
    }
    static{
        System.out.println("A.static");
    }

    A(){
        System.out.println("A的constructor");
    }
    void out(){
        System.out.println(i+"----"+j);
    }
}

class B extends A{

    int i = 4;
    int j = 4;
    {
        System.out.println("B1");
    }
    static{
        System.out.println("B.static");
    }
    B(){
        System.out.println("B的constructor");
    }


}

class C extends B {
    int i = 3;
    int j = 3;
    {
        System.out.println("C1");
    }
    static {
        System.out.println("C.static");
    }

    C() {
        System.out.println("C的constructor");
    }


}