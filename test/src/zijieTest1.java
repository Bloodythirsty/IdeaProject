import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class zijieTest1 {
    public static void main(String[] args) {
        // String s = "abbbaaccb";
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Set<Character> set = new HashSet<>();
        for(int i=0;i<s.length();i++){
            set.add(s.charAt(i));
        }
        int start = 0,length = 0x7FFFFFFF;
        for (int i = 0; i < s.length()-1; i++) {
            if (s.charAt(i) == s.charAt(i+1)) continue;
            Set<Character> set1 = new HashSet<>();
            for (int j = i; j < s.length(); j++) {
                set1.add(s.charAt(j));
                if(set.size() == set1.size()){
                    if(j-i+1 < length){
                        start = i;
                        length = j-i+1;
                        break;
                    }
                }
            }
        }

        if (set.size() == 1) length = 1;

        System.out.println(start + "," + length);
    }
}
