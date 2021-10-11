package _0928Baidu;

import java.util.Scanner;

/**
 * @author zhangkangkang
 * @date 2021/09/28 19:37
 */
public class BaiduTest1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String operates = sc.nextLine();
        int x=0,y=0;
        for (char c : operates.toCharArray()) {
            switch (c){
                case 'R': x++;break;
                case 'U': y++;break;
                case 'L': x--;break;
                default:y--;break;
            }
        }
        System.out.println("("+x+","+y+")");
    }
}
