public class Lc167 {
    public static void main(String[] args) {

    }
    public static int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        if (numbers==null || numbers.length<=0)
            return res;
        int left = 0;
        int right = numbers.length-1;
        while (left<right && left<numbers.length){
            if (numbers[left]+numbers[right]==target)
            {
                res[0] = left;
                res[1] = right;
                return res;
            }
            else if (numbers[left]+numbers[right] < target){
                left++;
            }
            else
                right--;
        }
        return res;
    }
}
