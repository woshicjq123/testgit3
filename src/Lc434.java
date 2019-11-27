import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

public class Lc434 {
    public static void main(String[] args) {
        String str = "Of all the gin joints in all the towns in all the world ";
        System.out.println(countSegments(str));
    }

    public static int countSegments(String s) {
        int count = 0;
        int start = 0;
        if (s==null || s.length()==0)
            return 0;
        while (start<s.length() && s.charAt(start)==' ')
            start++;
        int i = start;
        if (start == s.length())
            return 0;
        count++;
        while (i < s.length()-1) {
            if (s.charAt(i)==' ' && s.charAt(i+1)!=' ')
                count++;
            i++;
        }
        return count;
    }

    public static boolean isAlpha(char ch){
        if (ch>='A'&& ch<='Z')
            return true;
        if (ch>='a'&& ch<='z')
            return true;
        return false;
    }
}
