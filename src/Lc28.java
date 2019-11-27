public class Lc28 {
    public static void main(String[] args) {

    }

    public int strStr(String haystack, String needle) {
        int i = 0;
        if (needle.length()==0 && haystack.length()==0)
            return 0;
        if (needle == null ^ haystack == null)
            return 0;
        if (needle.length()==0)
            return -1;
        if (haystack.length() < needle.length())
            return -1;
        while (i<haystack.length()){
            if (haystack.substring(i,i+1).equals(needle.substring(0,1)))
            {
                if (i<haystack.length() && needle.length()+i<haystack.length() && haystack.substring(i,needle.length()+i).equals(needle)){
                    return i;
                }
                else
                    i++;
            }
            else
                i++;
        }
        return -1;
    }
}
