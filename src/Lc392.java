/**
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 *
 * 你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。
 *
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 *
 * 示例 1:
 * s = "abc", t = "ahbgdc"
 *
 * 返回 true.
 *
 * 示例 2:
 * s = "axc", t = "ahbgdc"
 *
 * 返回 false.
 */

public class Lc392 {
    public static void main(String[] args) {
        String s = "axc";
        String t = "ahbgdc";
        System.out.println(isSubsequence(s,t));
    }

    /** 对于
     * 特殊情况，字符串为空或者字符串相等
     * 当s[i] == t[j],那么i++.j++
     * 当不相等的时侯，j++
     * 当j=
     */
    public static boolean isSubsequence(String s, String t) {
        if (s==null)
            return true;
        if (s.equals(t))
            return true;
        int i=0;
        int j =0;
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();
        boolean flag = false;
        while (i<s.length()){
            while (j<t.length()){
                if (i<s.length()&& s1[i]==t1[j]){
                    i++;
                    j++;
                }
                else
                    j++;
            }
            if (i==s.length())
            {
                return true;
            }
            if (j==t.length())
                return flag;
        }
        return flag;
    }

    /**
     * 动态规划，对于字符串t进行动态规划
     * 对字符串t进行遍历，d[i] =
     */
    public static boolean isSubsequence1(String s, String t) {
        if (s==null || s.length()==0)
            return true;
        if (s.equals(t))
            return true;
        int index = 0;
        int index1 = 0;
        for (char ch:s.toCharArray()){
            index1 = t.indexOf(ch,index); //从第0个开始进行查找
            if (index1 == -1)
                return false;
            else
                index = index1 + 1;
        }
        return true;

    }

}
