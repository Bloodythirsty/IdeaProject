package bianlif;

import java.util.*;

public class Test1 {
    public static void main(String[] args) {

        Map<String,String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        List<String> res = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        String oldLine = sc.nextLine();
        String newLine = sc.nextLine();

        String[] oldStrs = oldLine.split(",");
        for (String str : oldStrs) {
            String[] idAndStr = str.split("-");
            map.put(idAndStr[0],idAndStr[1]);
        }

        String[] newStrs = newLine.split(",");
        for (String str : newStrs) {
            String[] isAndStr = str.split("-");
            String key = isAndStr[0];
            set.add(key);
            String newValue = isAndStr[1];
            if (map.containsKey(key) && !map.get(key).equals(newValue)){
                res.add("modify-"+key);
            }
            if (!map.containsKey(key)){
                res.add("add-"+key);
            }
        }

        for (String s : map.keySet()) {
            if (!set.contains(s)) res.add("delete-"+s);
        }
        // res.sort(String::compareTo);
        if (res.size()>0) System.out.print(res.get(0));
        for (int i = 1; i < res.size(); i++) {
            System.out.print(","+res.get(i));
        }
    }
}
