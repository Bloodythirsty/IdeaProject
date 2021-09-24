package _0918wangyi;

/**
 * @author zhangkangkang
 * @date 2021/09/18 19:36
 */
public class WangyiTest2 {
    public static void main(String[] args) {
        String s = "CCCCC";
        int m = 3;

        int result = 1;
        int index = 1;
        while (index < s.length()){
            // 不用魔法
            if (m == 0){
                result += (Math.abs(s.charAt(index) - s.charAt(index-1)))%26;
                result++;
                index++;
            }else {
                int i = index;
                int noMagic = 0;
                while (i < s.length() && (i - index) < m){
                    noMagic += (Math.abs(s.charAt(i) - s.charAt(i-1)))%26;
                    noMagic++;
                    i++;
                }

                int j = index;
                int magic = 0;
                if (j + m >= s.length() ){
                    magic = 0x7fffffff;
                }else {
                    while (j < s.length() && (j - index) < m){
                        magic += 2;
                        j++;
                    }
                }

                if (magic >= noMagic){
                    result += noMagic;
                }else {
                    result += magic;
                }
                index = i;
            }
        }

        System.out.println(result);

    }
}
