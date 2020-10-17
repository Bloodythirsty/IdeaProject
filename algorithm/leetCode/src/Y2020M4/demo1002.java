package Y2020M4;

public class demo1002 {
    /*

    示例 1：

输入：["bella","label","roller"]
输出：["e","l","l"]
示例 2：

输入：["cool","lock","cook"]
输出：["c","o"]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/find-common-characters
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

  这样解出来用力二不对：
  输入：
["cool","lock","cook"]
输出：
["c","o","o"]
预期结果：
["c","o"]


    public List<String> commonChars(String[] A) {
        List<String> list = new ArrayList<>();
        if(A.length == 0 || A ==null){
            return list;
        }
        for( int j = 0; j < A[0].length();j++ ){
                StringBuilder sb = new StringBuilder();
                sb.append(A[0].charAt(j));
                boolean flag = true;
                for(int k = 0; k < A.length; k++){
                    if(!A[k].contains(sb)){
                        flag = false;
                        break;
                    }
                }
                if(flag)
                    list.add(sb.toString());
            }
        return list;
    }
     */

    /*
    正确解法：做每个字母的交集

    我们知道第一个字符串的字符数量列表为：

b 1
e 1
l 2
a 1
第二个字符串的字符数量列表为：

l 2
a 1
b 1
e 1
第三个字符串的字符数量列表为：

r 2
o 1
l 2
e 1
这三个求交集后的结果为：

e 1
l 2


public List<String> commonChars(String[] A) {
        List<String> list = new ArrayList<>();
        if(A == null||A.length == 0) return list;
        int[] res = new int[26];
        //要是重复的字母，一定在第一个单词中出现，所以先把第一个单词中的字母拿出来
        for(char c:A[0].toCharArray()){
            res[c - 'a']++;
        }
        for(int i = 1; i < A.length; i++){
            //遍历每个单词，字母个数装入数组
            int[] temp = new int[26];
            for(char c:A[i].toCharArray()){
                temp[c - 'a']++;
            }
            //比较res和temp的数组中字母个数比较小的，选择小的
            for(int j = 0; j < 26; j++){
                res[j] = Math.min(res[j],temp[j]);
            }
        }

        //把int[] res转化成list<String>
        for(int i = 0; i < 26; i++){
            if(res[i] > 0){
                //每个数组值代表字母的个数，所以循环添加（有几个，添几个）
                for(int j = 0; j < res[i]; j++){
                    list.add((char)(i+'a')+"");
                }
            }
        }
        return list;
    }
     */
}
