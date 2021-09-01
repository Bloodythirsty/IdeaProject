package hulu;

import java.util.*;

public class HuluTest2 {
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

        HashMap<Integer, List<Integer>> status = new HashMap<>();
        ArrayList<Integer> RIndexs = new ArrayList<>();
        ArrayList<Integer> LIndexs = new ArrayList<>();
        for (int i = 0; i < source.length(); i++) {
            if (source.charAt(i) == 'R'){
                RIndexs.add(i);
            }
            if (source.charAt(i) == 'L'){
                LIndexs.add(i);
            }
        }

        while (!RIndexs.isEmpty() || !LIndexs.isEmpty()){
            result = new StringBuilder(finalStr);
            replace(result, RIndexs);
            replace(result, LIndexs);
            System.out.println(result);
            incre(v, RIndexs);
            incre(-v, LIndexs);
            removeOther(source, RIndexs);
            removeOther(source, LIndexs);
        }
    }

    private static void replace(StringBuilder result, ArrayList<Integer> LIndexs) {
        for (Integer lIndex : LIndexs) {
            result.replace(lIndex, lIndex + 1, "X");
        }
    }

    private static void incre(int v, ArrayList<Integer> RIndexs) {
        for (int i = 0; i < RIndexs.size(); i++) {
            RIndexs.set(i, RIndexs.get(i) + v);
        }
    }

    private static void removeOther(String source, ArrayList<Integer> RIndexs) {
        Iterator<Integer> Ritereator = RIndexs.iterator();
        while (Ritereator.hasNext()){
            int temp = Ritereator.next();
            if(temp <0 || temp >= source.length()){
                Ritereator.remove();
            }
        }
    }
}
