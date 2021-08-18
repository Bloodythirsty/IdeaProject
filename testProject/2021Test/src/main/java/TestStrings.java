import java.util.Arrays;

public class TestStrings {
    public static void main(String[] args) {
        String[] arr = {"40","9","7","20","1","0","0"};
        Arrays.sort(arr,(o1,o2)->(o2+o1).compareTo(o1+o2));
        for (String s : arr) {
            System.out.println("s = " + s);
        }

    }
}
