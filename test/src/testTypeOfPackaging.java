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
}
