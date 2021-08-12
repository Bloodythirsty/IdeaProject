import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhangkangkang
 * @date 2021/08/09 11:06
 */
public class _1626计算器 {
    public static void main(String[] args) {
//        String source = " 3+5 / 2 * 5 + 1 -3*2/2";
        String source = "3*2/2/3";
        int calculate = calculate(source);
        System.out.println("calculate = " + calculate);

    }

    public static int calculate(String s){
        String[] nums = s.split("[^0-9]");
        List<Integer> numList = Arrays.stream(nums).filter(e -> !e.equals("") && !e.equals(" ")).map(Integer::parseInt).collect(Collectors.toList());
        String[] operate = s.split("[0-9]");
        List<Character> operateList = Arrays.stream(operate).filter(e -> !e.equals("") && !e.equals(" ")).map(String::trim).map(e -> e.charAt(0)).collect(Collectors.toList());

        LinkedList<Integer> numStack = new LinkedList<>();
        LinkedList<Character> operateStack = new LinkedList<>();

        boolean isDivOrMul = false;
        for(int i=0,j=0;i<numList.size() ; i++,j++){
            if(isDivOrMul){
                int res;
                char op = operateStack.pollFirst();
                if(op == '/'){
                    res = numStack.pollFirst() / numList.get(i);
                }else{
                    res = numStack.pollFirst() * numList.get(i);
                }
                isDivOrMul = false;
                numStack.push(res);
            }else{
                numStack.push(numList.get(i));
            }

            if(j < operateList.size()){
                if(operateList.get(j) == '-' || operateList.get(j) == '+'){
                    operateStack.push(operateList.get(j));
                }else{
                    operateStack.push(operateList.get(j));
                    isDivOrMul = true;
                }
            }
        }

        int result = numStack.pollLast();
        while (!operateStack.isEmpty()){
            char op = operateStack.pollLast();
            if(op == '-'){
                result -= numStack.pollLast();
            }else{
                result += numStack.pollLast();
            }
        }



        return result;

    }
}
