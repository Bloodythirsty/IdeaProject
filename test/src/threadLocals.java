public class threadLocals {

    private static ThreadLocal<Integer> first = new ThreadLocal<Integer>();
    private static ThreadLocal<Integer> second = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return 2;
        }
    };
    private static ThreadLocal<Integer> third = new ThreadLocal<Integer>();

    public static void main(String[] args) {
        first.set(55);
        System.out.println("args = " + first.get());
        System.out.println("second.get() = " + second.get());
    }
}
