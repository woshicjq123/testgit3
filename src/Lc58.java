public class Lc58 {
    public static void main(String[] args) {

    }

    /**
     *  如果不是空格，那么++，如果遇到空格,则
     */
    public int lengthOfLastWord(String s) {
        if (s==null || s.length()==0)
            return 0;
        char[] array = s.toCharArray();
        int len = 0;
        int oldlen = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == ' '){
                len = 0;
            }
            else {
                len++;
                oldlen = len;
            }
        }
        return oldlen;
    }
}
