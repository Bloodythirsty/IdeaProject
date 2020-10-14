package testInterface;

public class AImpl implements AInterface{
    public static void test(AInterface aInterface) {

    }


    public static void main(String[] args) {
        AInterface a = new AImpl();
        test(a);

    }

    @Override
    public int find() {
        return 0;
    }
}
