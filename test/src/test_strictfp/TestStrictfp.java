package test_strictfp;

// public strictfp class TestStrictfp {
public  class TestStrictfp {
    public static void add() {
        float a = 0.0123456f;
        double d = 0.03496421d;

        double sum = a + d;

        System.out.println("sum = " + sum);
    }

    public static void main(String[] args) {
        add();
        long a = 2147483647;

        String s = " ABC";
        System.out.println(s.codePointAt(0));
        System.out.println(s.codePointAt(1));
        System.out.println(s.codePointAt(2));

        Character c ='a';
        System.out.println(Character.charCount(65));
        int[] ints ;

    }

}
