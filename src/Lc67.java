/**
 *
 */
public class Lc67 {
    public static void main(String[] args) {

    }
    public static String addBinary(String a, String b) {
        //LinkedList<Integer> array = new LinkedList<>();
        String res = "";
        char[] s1 = a.toCharArray();
        char[] s2 = b.toCharArray();
        char[] s3 = s2;
        //求两个字符串的长度，将两个字符串的长度保持一致。短的那个高位补0
        //然后进行计算。
        int len1 = s1.length;
        int len2 = s2.length;
        if (len1<len2){ //保证s1的长度是最长的。交换的时候注意把字符串长度很字符串一起交换
            s3 = s1;
            s1 = s2;
            s2 = s3;
            int temp = len1;
            len1 = len2;
            len2 = temp;
        }
        int jw = 0;
        int cur = 0;
        for (int i = len2-1; i >= 0; i--) { //注意字符的加法可以采用-'0'这么加
            cur = (s1[i + len1-len2]-'0') + (s2[i] - '0') + jw;
            jw = cur / 2;
            cur = cur%2;
            res = cur + res;
        }
        if (len1 == len2 && jw!=0)
            return jw + res;
        else if (len1 == len2 && jw==0)
            return res;
        else {
            for (int i = len1 - len2-1; i >= 0; i--) {
                cur = s1[i] - '0' + jw;
                jw = cur / 2;
                cur = cur % 2;
                res = cur + res;
            }
            if (jw != 0)
                return jw + res;
            else
                return res;
        }
    }
}
