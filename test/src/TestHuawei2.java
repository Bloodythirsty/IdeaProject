import java.util.*;

public class TestHuawei2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str;
        while (sc.hasNext()) {
            str = sc.nextLine();
            String[] split = str.split("[^0-9]");
            Map<Integer,Integer> map = new HashMap<>();
            for (String s : split) {
                if (!s.equals("")){
                    int key = Integer.parseInt(s);
                    if (map.containsKey(key)){
                        map.put(key,map.get(key)+1);
                    }else {
                        map.put(key,1);
                    }
                }
            }
            int result = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int key = entry.getKey();
                int value = entry.getValue();
                if (value <= key + 1){
                    result = result+key + 1;
                }else {
                    int temp = value;
                    int colors = value/(key+1);
                    if (value%(key+1) != 0){
                        colors++;
                    }
                    result = result + colors*(key+1);
                }
            }
            System.out.println(result);
        }
    }
}
