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
}
