import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * 数组的每个索引做为一个阶梯，第 i个阶梯对应着一个非负数的体力花费值 cost[i](索引从0开始)。
 *
 * 每当你爬上一个阶梯你都要花费对应的体力花费值，然后你可以选择继续爬一个阶梯或者爬两个阶梯。
 *
 * 您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯。
 *
 * 示例 1:
 *
 * 输入: cost = [10, 15, 20]
 * 输出: 15
 * 解释: 最低花费是从cost[1]开始，然后走两步即可到阶梯顶，一共花费15。
 *  示例 2:
 *
 * 输入: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 * 输出: 6
 * 解释: 最低花费方式是从cost[0]开始，逐个经过那些1，跳过cost[3]，一共花费6。
 */
public class Lc746 {
    public static void main(String[] args) {
        String s1 = "100";
        String s2 = "110010";
      //  System.out.println(addBinary(s1,s2));
    }

    public static int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        for (int i = 0; i < dp.length; i++) {
            if (i<2)
                dp[i] = cost[i]; //
            else{
                dp[i] = Math.min(dp[i-1],dp[i-2]+cost[i]);
            }
        }
        if (cost.length==2)
            return Math.min(cost[0],cost[1]);
        else
            return Math.min(dp[cost.length-1-1],dp[cost.length-1-2]+cost[cost.length-1]);
    }


    public static boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote==null)
            return true;
        //hashmap存储两个字符串数组的字符以及数量，遍历两个字符串，
        HashMap<Character,Integer> hashmap = new HashMap<>();
        char[] array1 = ransomNote.toCharArray();
        char[] array2 = magazine.toCharArray();
        for (char ch:array1){
            if (hashmap.containsKey(ch))
                hashmap.put(ch,hashmap.get(ch)+1);
            else
                hashmap.put(ch,1);
        }
        HashMap<Character,Integer> hashmap2 = new HashMap<>();
        for (char ch:array2){
            if (hashmap2.containsKey(ch))
                hashmap2.put(ch,hashmap2.get(ch)+1);
            else
                hashmap2.put(ch,1);
        }

        for (char ch:hashmap.keySet()){
            if (!hashmap2.containsKey(ch)|| hashmap.get(ch)>=hashmap2.get(ch))
                return false;
        }
        return true;
    }

    /**
     * 定义一个bool数组，while index获取以后发现true,那么从下一个进行获取，如果没有则返回false。
     */
    public static boolean canConstruct1(String ransomNote, String magazine) {
        int len1 = ransomNote.length();
        int len2 = magazine.length();
        if (len1>len2)
            return false;
        if (ransomNote == null)
            return true;
        boolean[] flag = new boolean[len2];
        //还可以进行优化，将查找到的元素下标记录在hashmap中，注意记录的是最新的下标。
        char[] array = ransomNote.toCharArray();
        int index=0;
        int index1 = -1;
        for(char ch:array){
            index1 = magazine.indexOf(ch,index); //获取每个字符在字符串中的位置
            if (index1==-1)//如果没有则返回false
                return false;
            else
            {
                while (index1>=0 && index1<len2 && flag[index1]==true) //如果找到了但是已经被用过，那么继续找
                    index1 = magazine.indexOf(ch,index1+1);
                if (index1==-1) //继续找没找到
                    return false;
                else//继续找找到了那么改变标志位。
                    flag[index1] = true;
            }
        }
        return true;
    }

    /**
     * 遍历字符串，记录每个空格后面的，并且要注意，空格位置初始化为-1，然后空格的位置在字符串内，那么返回后面的长度，如果空格的位置在
     * 字符串结尾，那么返回0
     */

    /********** 58****/
    public static int lengthOfLastWord(String s) {
        int index  = -1;
        if (s==null||s.length()==0)
            return 0;
        char[] array = s.toCharArray();
        int len = 0;
        int i = 0;
        boolean flag = false;
        while (i<array.length){
            if (array[i]==' '){
                if(i==array.length-1) //空格出现在最后一位
                    return 0;
                else //空格并没有出现在最后一位，所以这时候给长度设为0
                    len = 0;
                while (i<array.length && array[i]==' ') //防止空格后面还是空格
                    i++;
                if (i<array.length)
                {
                    while (i<array.length && array[i]!=' ') { //数组后面并不都是空格，记录后面的长度
                        len++;
                        i++;
                    }
                }
                else//防止数组后面全是空格
                    return 0;
                flag = true;
            }
            else
                i++;
        }
        if (flag==false)
            return array.length;
        return len;
    }
//利用两个指针，这两个指针之间的是单词长度
    public static int lengthOfLastWord1(String s) {
        if (s==null || s.length()==0)
            return 0;
        int i = 0;
        int j = 0;
        int len = 0;
        char[] array = s.toCharArray();
        boolean flag = false; //多个空格
        while (i<array.length){
            if (array[i] == ' '){ //
                len = i - j;
                while (i<array.length && array[i]==' ')
                    i++; //防止连续的空格出现
                j = i; //记录了下一个不为空格开始的位置
                flag = true;
            }
            else
                i++;
        }
        if (flag)
            return len;
        else
            return array.length;
    }
    /**
     * 首先两个指针都指向0,0，一个指针走，直到要么到结尾要么到空格，如果到直接直接返回，i-j
     * 如果没有到结尾而是遇到了空格那么就开始i-j
     *
     */
    /**
     *示例 1:
     *
     * 输入: a = "11", b = "1"
     * 输出: "100"
     * 示例 2:
     *
     * 输入: a = "1010", b = "1011"
     * 输出: "10101"
     */
}
