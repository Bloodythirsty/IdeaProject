import org.junit.Test;

public class TestRegix {
    public static void main(String[] args) {
        String s = "(u(love)i)";
        String[] split = s.split("[(|)]");
        for (String s1 : split) {
            System.out.println("s1 = " + s1);
        }

    }

    @Test
    public void test1(){
        String s = "u.love.i";
        String[] split = s.split("\\.");
        for (String s1 : split) {
            System.out.println("s1 = " + s1);
        }
    }

    @Test
    public void test2(){
        StringBuilder sb = new StringBuilder("abc");
        sb.delete(0,sb.capacity());
        sb.reverse();
        System.out.println("sb.toString() = " + sb.toString());
    }
}
