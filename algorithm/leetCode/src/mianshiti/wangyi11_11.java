package mianshiti;

import org.junit.Test;

public class wangyi11_11 {

    /*
1） 用竖线 | 分隔字符串，你将得不到预期的结果
           例如：String[] aa = "aaa|bbb|ccc".split("|"); 得到的结果是每个字符都进行了分割（可自行验证），并不是预期的效果。应该将代码部分改为String[] aa = "aaa|bbb|ccc".split("\\|"); 这样才能得到正确的结果。
（2）用 * 分隔字符串运行将抛出java.util.regex.PatternSyntaxException异常，用加号 + 也是如此。
           例如：String[] aa = "aaa*bbb*ccc".split("*"); 与上文同理应该改为String[] aa = "aaa|bbb|ccc".split("\\*"); 这样才能得到正确的结果。
（3）还有如果想在串中使用"\\"字符，则也需要转义。应该这样使用：String[] aa = "aaa\\bbb\\bccc".split("\\\\");
（4） 还有就是点号"."，与上文同理即为：String[] aa = "aaa.bbb.bccc".split("\\."); 。
     */

    public String two(String ip){
        String[] ips = ip.split("\\.");
        for (String s : ips) {
            System.out.println("s = " + s);
        }
        return null;
    }

    public long ips(String ip){
        long res = 0;
        String[] ips = ip.split("\\.");
        for(int i= ips.length-1; i>=0; i--){
            int s_int = Integer.parseInt(ips[ips.length-1-i]);
            for (int j=0;j<8;j++){
                if ((s_int&(1<<j))==1){
                    res += 1<<(i<<3+j);
                }
            }
        }
        return res;
    }

    @Test
    public void test(){
        String ip = "0.0.0.1";
        long ips = ips(ip);
        System.out.println("ips = " + ips);
    }

    @Test
    public void testCharToInt(){
        char c = '1';
        int c1 = (c - 48);
        System.out.println("c = " + c);
        System.out.println("c1 = " + c1);

        int int1 = 2;
        char char2 = 2+48;
        System.out.println("char2 = " + char2);
        System.out.println(char2 == '2');

    }
}
