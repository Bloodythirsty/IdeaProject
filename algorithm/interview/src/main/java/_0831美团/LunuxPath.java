package _0831美团;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author zhangkangkang
 * @date 2021/09/01 13:15
 */
public class LunuxPath {
    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int a = in.nextInt();
        //System.out.println(a);
        String path = "/./aa/bb/../mn/xx/../hh/yy/.././../";
        String result = "";
        if(handle(path,result)){
            System.out.println(result);
        }else{
            System.out.println("error");
        }

    }

    public static boolean handle(String path,String result){
        String[] paths = path.split("\\/");
        Deque<String> queue = new ArrayDeque<>();
        for(String curr:paths){
            if(curr.equals(".")){
                continue;
            }else if(curr.equals("..")){
                queue.removeLast();
            }else{
                queue.addLast(curr);
            }
        }
        StringBuilder sb  = new StringBuilder();
        while(!queue.isEmpty()){
            sb.append(queue.pollFirst()).append("/");
        }
        result = sb.toString();
        System.out.println(result);
        return true;
    }
}
