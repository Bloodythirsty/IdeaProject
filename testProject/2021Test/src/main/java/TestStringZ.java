import java.util.ArrayList;
import java.util.List;

public class TestStringZ {
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        convert(s,1);

    }

    public static void convert(String s, int numRows) {
        // if(s.length()==1) return s;
        List<List<String>> lists = new ArrayList<>();

        List<String> list = new ArrayList<>();
        list.add((s.charAt(0)+""));
        lists.add(list);

        for(int i = 1; i < numRows; i++){
            lists.add(new ArrayList<>());
        }

        int index = 1;
        int zIndex = 1;
        int step = 1;
        int times = 1;
        while(index < s.length()){
            String temp = s.charAt(index) + "";
            List<String> listI = lists.get(zIndex);
            listI.add(temp);


            if(times % 2 == 1){
                zIndex++;
                if(step == numRows-1){
                    zIndex -= 2;
                    step = 0;
                    times++;
                }
            }else{
                zIndex--;
                if(step == numRows-1){
                    zIndex += 2;
                    step = 0;
                    times++;
                }
            }

            index++;
            step++;
        }

        StringBuilder sb = new StringBuilder();
        for (List<String> list1 : lists) {
            for (String s1 : list1) {
                sb.append(s1);
            }
        }
        System.out.println("sb.toString() = " + sb.toString());

    }
}
