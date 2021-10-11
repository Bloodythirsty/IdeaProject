package _0926huawei;

/**
 * @author zhangkangkang
 * @date 2021/09/26 15:50
 */
public class HuaweiTest1 {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "adabcd";
        int index = findSubString(s1, s2);
    }

    private static int findSubString(String s1, String s2) {
        if (s1.length() > s2.length()) return -1;
        int i=0,j=0;
        while (i < s1.length() && j < s2.length()){
            if (s1.charAt(i) == s2.charAt(j)){
                i++;
                j++;
            }else {
                j++;
            }
        }
        if (i == s1.length()) return  j-1;
        return -1;
    }
}
