package Y2020M4;

public class demo05 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("ab"));
    }
    public static String longestPalindrome(String s) {
        int i=1,head=0,tail=0,max=0;
        int length = s.length();
        char[] chars = s.toCharArray();

        //处理开头边界，length==1（2）
        if(length == 1) return s;
        if(length ==2){
            if(chars[0] == chars[1]){
                max = 2;
                s = new StringBuilder().append(chars,0,2).toString();
            }else {
                s = new StringBuilder().append(chars,0,1).toString();
            }
        }
        // 处理length>3，具有普遍性
        while(i < length -1){
            //处理  abbac
            if(chars[i] == chars[i+1]){
                head = i-1;
                tail = i+2;
                while((head >=0) && (tail < length) && chars[head] == chars[tail]){
                    head--;
                    tail++;
                }
                if((tail - head -1) > max){
                    max = tail - head -1;
                    s = new StringBuilder().append(chars,head+1,max).toString();
                }
            }
            /*
                不应该分开判断：如  aabbbbb
             */
            head = i-1;
            tail = i+1;
            while((head >=0) && (tail < length) && chars[head] == chars[tail]){
                head--;
                tail++;
            }
            if((tail - head -1) > max){
                max = tail - head -1;
                s = new StringBuilder().append(chars,head+1,max).toString();
            }
            i++;
        }

        return s;
    }
}
