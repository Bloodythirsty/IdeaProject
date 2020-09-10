public class testReference {

    public static void main(String[] args) {
        StringBuffer ss1 = new StringBuffer("hello");
        StringBuffer ss2 = new StringBuffer("hello");

        TestReference(ss1,ss2);

        System.out.println("ss1 = " + ss1);
        System.out.println("ss2 = " + ss2);
    }

    //s1指向ss1所指向的内存 , s2指向ss2所指向的内存
    public static void TestReference(StringBuffer s1, StringBuffer s2){
        s1.append(" word"); //把ss1的内存改变了
        s2 = s1;            //s2指向了s1所指向的内存，而ss2无变化
    }
}
