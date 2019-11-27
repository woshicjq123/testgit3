/**
 * 反转字符串中的元音字符：
 * 1）元音字符可能是大写可能是小写
 * 2）翻转的时候注意字符边界，left应该是不小于right
 */
public class Lc345 {
    public static void main(String[] args) {
        String s1 = "hello";
        System.out.println(reverseVowels(s1));
    }

    public static String reverseVowels(String s) {
        if (s==null || s.length()==1)
            return s;
        int len = s.length();
        char[] array = s.toCharArray();
        int left = 0;
        int right = len -1 ;
        char temp;
        while (left < right && left<len){
            while (left<right && isYuan(array[left])==false)
                left++;
            while (left<right &&isYuan(array[right])==false)
                right--;
            temp = array[left];
            array[left] = array[right];
            array[right]=temp;
            left++;
            right--;
        }
        return String.valueOf(array);
    }

    public static boolean isYuan(char ch){
        if (ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'||ch=='A'||ch=='E'||ch=='I'||ch=='O'||ch=='U')
            return true;
        return false;
    }
}
