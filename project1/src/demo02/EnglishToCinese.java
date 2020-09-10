package demo02;

import java.util.Scanner;

public class EnglishToCinese {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String s1 = s.replace(",", "，");
        // StringBuilder sb = new StringBuilder(s);
        System.out.println("s1 = " + s1);
    }
}
