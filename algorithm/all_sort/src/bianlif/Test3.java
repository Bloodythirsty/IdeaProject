package bianlif;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String source = sc.nextLine();
        int flag = 1;
        // String[] split = source.split("[^0-9]");
        String[] split = source.split("/");
        int index = 0;
        int numerator = 0;
        int denominator = 0;
        for (String s : split) {
            if(!s.equals("") && s.charAt(0) == '-'){
                flag *= -1;
                if (index == 0){
                    numerator = Math.abs(Integer.parseInt(split[0]));
                    index++;
                }else {
                    denominator = Math.abs(Integer.parseInt(split[1]));
                }
            }
        }


        String intPart = "",littlePart = "";
        List<String> res = new ArrayList<>();
        if (numerator % denominator == 0) {
            System.out.println(numerator/denominator);
            return;
        }
        intPart = numerator/denominator + "";
        int yushu = numerator%denominator;
        while (yushu != 0){
            if(!res.contains(yushu+"")){
                res.add(yushu+"");
            }else {
                int i;
                for (i=0;i<res.size();i++){
                    if(res.get(i).equals(yushu+"")) break;
                }
                littlePart = littlePart.substring(0,i)+"(" + littlePart.substring(i,littlePart.length()) + ")";
                break;
            }
            yushu = yushu * 10;
            littlePart += yushu/denominator+"";
            yushu = yushu%denominator;
        }
        String res1 = "";
        if (flag == -1){
            res1 = "-" + intPart + "." +littlePart;
        }else{
            res1 = intPart+ "." +littlePart;
        }
        System.out.println(res1);
    }
}
