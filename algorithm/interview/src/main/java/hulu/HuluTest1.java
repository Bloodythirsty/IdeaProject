package hulu;

import java.util.ArrayList;
import java.util.Scanner;

public class HuluTest1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        String source = sc.next();
        int channelLength = source.length();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < channelLength; i++) {
            result.append(".");
        }
        String finalStr = result.toString();
        int RIndex = source.indexOf("R");
        int LIndex = source.indexOf("L");
        ArrayList<Integer> indexs = new ArrayList<>();
        if(RIndex != -1){
            int currIndex = RIndex;
            while (currIndex <= channelLength){
                indexs.add(currIndex);
                currIndex += v;
            }
        }else if (LIndex != -1){
            int currIndex = LIndex;
            while (currIndex >= 0){
                indexs.add(currIndex);
                currIndex -= v;
            }
        }
        for (Integer index : indexs) {
            result.replace(index,index+1,"X");
            System.out.println(result);
            result = new StringBuilder(finalStr);
        }

        System.out.println(finalStr);
    }
}

/*

2
..R....
 */