import java.util.HashMap;

public class Lc189 {
    public static void main(String[] args) {
        String str = "0P";
        System.out.println(isPalindrome(str));
    }

    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k = k%nums.length;
        if (k==0)
            return;
        int i = 0;
        int temp = 0;
        while (i<k){
            temp = nums[i];
            nums[nums.length - k + i] = nums[i];
            if (i+k<nums.length){
                nums[i] = nums[i-1];
            }
        }
    }

    public boolean containsDuplicate(int[] nums) {
        if (nums==null || nums.length<=1)
            return false;
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i])) {
                return true;
            }
            else {
                hashMap.put(nums[i], 1);
            }
        }
        return false;
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums.length < k || nums==null)
            return false;
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i])){
                if ( i - hashMap.get(nums[i]) < k){ //这个跟上一个相比，距离过小
                    ; //
                }
                else if (i - hashMap.get(nums[i]) == k)
                    return true;
                else
                    hashMap.put(nums[i],i);
            }
            else{
                hashMap.put(nums[i],i);
                nums[i] = i;
            }
        }
        return false;
    }

    public static boolean isDigitOrAlpha(char ch){
        if (ch <= 'Z' && ch >= 'A')
            return true;
        else if (ch <= '9' && ch >= '0')
            return true;
        else if (ch <= 'z' && ch >= 'a')
            return true;
        else
            return false;
    }

    public static boolean charEquals(char ch1,char ch2){
        if (ch1>='0' && ch1 <='9' && ch2>='0'&&ch2 <='9' && ch1 == ch2)
            return true;
        else if (ch1>='a' && ch1 <='z' && ch2>='a'&&ch2 <='z' && ch1 == ch2)
            return true;
        else if (ch1>='A' && ch1 <='Z' && ch2>='A'&&ch2 <='Z' && ch1 == ch2)
            return true;
        else if (ch1>='a' && ch1 <='z' && ch2>='A'&&ch2 <='Z' && ch1 - ch2 == 32)
            return true;
        else if (ch1>='A' && ch1 <='Z' && ch2>='a'&&ch2 <='z' && ch1 - ch2 == -32)
            return true;
        else
            return false;
    }

    //
    public static boolean isPalindrome(String s) {
        if (s.length()==1 || s==null)
            return true;
        char[] array = s.toCharArray();
        //  boolean flag = false;
        int left = 0;
        int right = array.length -1;
        while (left < array.length && isDigitOrAlpha(array[left])==false)
            left++;
        if (left == array.length)
            return true;
        while (right >= left && isDigitOrAlpha(array[right])==false)
            right--;
        while (left<array.length && left<=right){
            if (charEquals(array[left],array[right])==false)
                return false;
            left++;
            while (left < array.length && isDigitOrAlpha(array[left])==false)
                left++;
            right--;
            while (right >= left && isDigitOrAlpha(array[right])==false)
                right--;
        }
        return true;
    }
    public int maxSubArray(int[] nums) {
        if (nums==null || nums.length == 0)
            return -1;
        if (nums.length == 1)
            return nums[0];
        int prevSum = nums[0];
        int curMaxSum = prevSum;
        int res = curMaxSum;
        for (int i = 1; i < nums.length; i++) {
            curMaxSum = Math.max(prevSum+nums[i],nums[i]);
            res = Math.max(curMaxSum,res);
            prevSum = curMaxSum;
        }
        return res;
    }

}
