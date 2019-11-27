import java.util.HashMap;

/**
 * 定义boolean类型数组，利用数组标记该字符是否出现过
 * 也可以通过hashmap进行累计次数，然后对字符串的每个字符进行遍历，不是对hashmap进行遍历，这样保证了次数
 */

public class Lc387 {
    public static void main(String[] args) {
        String s1 = "leetcode";
        System.out.println(firstUniqChar(s1));
    }

    /**
     * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
     */
    /**
     * hashMap可以存次数，但是不可以保证第一个
     * 暴力： 设置set，以及一个boolean型数组，
     */
    public static int firstUniqChar(String s) {
        if (s==null)
            return -1;
        if (s.length()==1)
            return 0;
        boolean[] array = new boolean[s.length()];
        int i = 0;
        int j = 0;
        while (i<array.length){
            if (array[i]==true && i<s.length())
            {
                i++;
                continue;
            }
            j = s.indexOf(s.charAt(i),i+1);
            if (j!=-1)
                array[i] = true;
            else
                return i;
            while (j!=-1 && j<array.length)
            {
                array[j] = true;
                j = s.indexOf(s.charAt(j),j+1);
            }
            i++;
        }
        return -1;
    }

    public int firstUniqChar1(String s) {
        HashMap<Character, Integer> count = new HashMap<Character, Integer>();
        int n = s.length();
        // build hash map : character and how often it appears
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        // find the index  //对字符串进行遍历
        for (int i = 0; i < n; i++) {
            if (count.get(s.charAt(i)) == 1)
                return i;
        }
        return -1;
    }

}
