package Y2020M4;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class 面试题16_26 {
    public int calculate(String s) {
        char[] chs = s.toCharArray();
        Deque<Character> queue = new ArrayDeque<>();

        boolean isMultiOrDiv = false;
        for(int i = 0; i < chs.length; i++){
            if(chs[i]==' ') continue;
            else if('0' <= chs[i] && chs[i] <= '9'){
                if(isMultiOrDiv){       //前一个是*/
                    char fuhao = queue.pollFirst();
                }else{
                    queue.addFirst(chs[i]);
                }
            }else if(chs[i] == '+' || chs[i] == '-'){
                queue.addFirst(chs[i]);
            }else if(chs[i] == '*' || chs[i] == '/'){
                isMultiOrDiv = true;
                queue.addFirst(chs[i]);
            }
        }

        return 0;
    }

    public int calculate_1(String s) {
        String[] nums = regex(s,"[^0-9]");
        String[] opers = regex(s,"[0-9]");

        Deque<Integer> queueNum = new ArrayDeque<>();
        Deque<Character> queueOperator = new ArrayDeque<>();

        boolean isMultiOrDiv = false;


        //同时遍历两个数组，每次遍历一个
        for(int i=0 , j=0; i< nums.length; i++){
            if(nums[i]==null || nums[i].length()==0) continue;
            else{
                if(isMultiOrDiv){
                    int res = 0;
                    if(queueOperator.pollFirst()=='/'){
                        res = queueNum.pollFirst()/Integer.parseInt(nums[i]);
                    }else if(queueOperator.pollFirst()=='*'){
                        res = queueNum.pollFirst()*Integer.parseInt(nums[i]);
                    }
                    isMultiOrDiv = false;
                    queueNum.addFirst(res);
                }else{
                    queueNum.addFirst(Integer.parseInt(nums[i]));
                }
                while(j < opers.length){
                    if(opers[j]==null || opers[j].length()==0){
                        j++;
                    }
                    else if(opers[j].charAt(0) == '-' || opers[j].charAt(0) == '+'){
                        queueOperator.addFirst(opers[j].charAt(0));
                        j++;
                        break;
                    }else if(opers[j].charAt(0) == '*' || opers[j].charAt(0) == '/'){
                        isMultiOrDiv = true;
                        queueOperator.addFirst(opers[j].charAt(0));
                        j++;
                        break;
                    }
                }
            }
        }
        int finalRes = queueNum.pollLast();
        while(!queueOperator.isEmpty()){
            char operator = queueOperator.pollLast();
            if(operator == '-'){
                finalRes -= queueNum.pollLast();
            }else{
                finalRes += queueNum.pollLast();
            }
        }


        return finalRes;
    }

    public String[] regex(String source , String reg){
        Pattern p = Pattern.compile(reg);
        Matcher m = p.matcher(source);
        String s = m.replaceAll(" ").trim();
        return s.split(" ");

    }

    @Test
    public void test(){
        String s = "  3  +  2*2  ";
        calculate_1(s);
    }
}
