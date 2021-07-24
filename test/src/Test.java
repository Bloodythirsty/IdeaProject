import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        String  s = "0123456789";
        String rev = rev(s);
        System.out.println("rev = " + rev);
    }

    public static String rev(String s){
        char[] chars = s.toCharArray();
        int low = 0;
        int high = chars.length - 1;
        while (low < high){
            char temp = chars[low];
            chars[low] = chars[high];
            chars[high] = temp;

            low++;
            high--;
        }
        return new String(chars);
    }

    @org.junit.Test
    public void Test(){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println("num = " + num);
        for (int i = 0; i < num+5; i++) {
            int source = sc.nextInt();
            System.out.println("source = " + source);
        }
    }

    @org.junit.Test
    public void Test1(){
        // Scanner sc = new Scanner(System.in);
        // String num = sc.nextLine();
        // System.out.println("num = " + num);
        // for (int i = 0; i < 5; i++) {
        //     String source = sc.nextLine();
        //     System.out.println("source = " + source);
        // }

        System.out.println("".equals("  "));
    }

    @org.junit.Test
    public void Test12(){
        Scanner sc = new Scanner(System.in);
        String num = sc.nextLine().trim();
        while (!num.equals("")){
            for (int i = 0; i < Integer.parseInt(num); i++) {
                String source = sc.nextLine().trim();
                System.out.println("source = " + source);
            }
            num = sc.nextLine().trim();
        }
    }

    @org.junit.Test
    public void Test121() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String numCount;
        while ((numCount = br.readLine())!=null){
            System.out.println("numCount = " + numCount);
            for (int i = 0; i < Integer.parseInt(numCount); i++) {
                String source = br.readLine();
                System.out.println("source = " + source);
            }
        }
    }

    @org.junit.Test
    public void Test1211() throws IOException {
        // StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        StreamTokenizer st = new StreamTokenizer(System.in);
        while (st.nextToken()!=-1){
            double nval = st.nval;
            System.out.println("nval = " + nval);
        }


        List<Character> lists = new ArrayList<>();


    }

    @org.junit.Test
    public void Test121122() throws IOException {
        String source = "10";
        StringBuilder sb = new StringBuilder();
        long num = Long.parseLong(source);
        for(int i=0; i<8; i++){
            long result = (num >> i) & 1;
            sb.insert(0,result);
        }
        System.out.println("sb = " + sb.toString());
    }
}
