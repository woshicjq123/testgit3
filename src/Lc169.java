import sun.util.resources.cldr.zh.CalendarData_zh_Hans_HK;

import java.util.HashMap;

public class Lc169 {
    public static void main(String[] args) {


    }
    public int majorityElement(int[] nums) {
        if (nums==null)
            return -1;
        if (nums.length==1 || nums.length==2)
            return nums[0];
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        int maxTimes = 0;
        int values = 0;
        for (int i = 0; i < nums.length; i++) {
            if(hashMap.containsKey(nums[i])){
                hashMap.put(nums[i],hashMap.get(nums[i]+1));
                if (hashMap.get(nums[i]) - maxTimes>0){
                    maxTimes = hashMap.get(nums[i]);
                    values = nums[i];
                }
            }
            else{
                hashMap.put(nums[i],1);
            }
        }
        return values;
    }
}
