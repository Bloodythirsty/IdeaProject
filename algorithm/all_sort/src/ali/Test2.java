package ali;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        // String s = "abcaabbcc";
        try{
            System.out.println(findCount());
        }catch (Exception e){
            System.out.println(-1);
        }
    }

    public static int findCount(){
        Scanner sc = new Scanner(System.in);
        String source = sc.nextLine();
        char[] chs = source.toCharArray();
        int a = 0, b = 0, c = 0;
        for (int i = 0; i < chs.length; i++) {
            if (chs[i] == 'a'){
                a++ ;
            }else if(chs[i] == 'b'){
                b += a;
            }else if(chs[i] == 'c'){
                c += b;
            }
        }
        return c;
    }
}
