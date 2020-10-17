package Y2020M4;
/*

给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

示例 1:

输入: "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:

输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:

输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。


 */
public class demo03 {
    public static void main(String[] args) {
        System.out.println("lengthOfLongestSubstring(\"ccadrf\") = " + lengthOfLongestSubstring("bcdbcdef"));

        int abcbced = lengthOfLongestSubstring_1("abcdcbd");
        System.out.println("abcbced = " + abcbced);
    }

    /*
            解法一：
                字母的asc码在 1-128内
                所以用长度为128的数组存下标
     */
    public static int lengthOfLongestSubstring(String s) {
        // 记录字符上一次出现的位置
        int[] last = new int[128];
        for(int i = 0; i < 128; i++) {
            last[i] = -1;
        }
        int n = s.length();

        int res = 0;    //rest就是长度，也是窗口末尾
        int start = 0; // 窗口开始位置
        for(int i = 0; i < n; i++) {
            int index = s.charAt(i);
            /*
                    last[index] + 1 ：
                     1. 只要没有重复出现，此处值为0
                     2. 若重复出现，则取出下标并+1，即重置了窗口开始位置
             */
            start = Math.max(start, last[index] + 1);

            /*
                    res就是窗口长度
             */
            res   = Math.max(res, i - start + 1);
            last[index] = i;
        }

        return res;
    }

    public static int lengthOfLongestSubstring_1(String s) {
        if (s.length() == 0 ){
            return 0;
        }
        char[] windows = new char[128];   //用于记录每个字符
        int left = 0 , right = 0 ;        //双指针控制窗口大小
        int maxlength = 0 ;               //记录窗口最大长度

        while(right< s.length()){
            char ch = s.charAt(right);
            windows[ch]++;

            //如果有重复字符则左边窗口一直加，直到剔除字符,直到重复字符的后一位
            /*
                    因为数组中只存了 1 或者 2
                    最初left为1，遇到重复的字符，则为2，进入内部循环开始剔除
               例子： abcdcbd  等待遇到第二个c时，数组情况如下，这个时候要把left移动到d，即3
                     1 1 2 1
                     首先把第一个1变成0,每次 left都+1，即向后移动了
                     等到把2变成1时，left刚好等于3.
                     思想就是
             */
            while (windows[ch] > 1){
                char ch1 = s.charAt(left);
                windows[ch1]--;             //就是为了当ch = ch1时的--，然后退出循环
                left++;
            }
            maxlength = Math.max(right - left+1 , maxlength);
            right++;
        }
        return maxlength;
    }
}

/*

滑动窗口：
设置两个指针 l 、r 分别表示为窗口的左右两端，初始化为 l = 0 ，r = -1 ；
每遇到一个新元素时，遍历窗口内的元素看是否出现过，
若在窗口内有同样的元素，则把左边界移到这个元素的后面一位；否则增加又边界。
时间复杂度：O（n*m），遍历了n次窗口，n为字符串长度，m为窗口长度。 空间复杂度：O（n）

public int lengthOfLongestSubstring(String s) {
        int l = 0, r = 0, max = 0;
        for(; r < s.length(); r++){
            for (int k = l; k < r; k++ ){
                if(s.charAt(r) == s.charAt(k)){
                    l = k+1;
                }
            }
            if(r-l+1 > max) max = r-l+1;
        }
        return max;
    }
 */