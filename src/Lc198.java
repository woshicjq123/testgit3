/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2:
 *
 * 输入: [2,7,9,3,1]
 * 输出: 12
 * 解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 */
public class Lc198 {
    public static void main(String[] args) {

    }

    /**
     * 如果数组长度为0，这时候返回0
     * 如果只有一个房子，那么此时的最大值就是Nums[1]
     * 如果有两个房子，那么就是Math.max(nums[0],nums[1])
     * 如果有三个房子，那么当前的最大值就是Math.max(nums[0]+nums[2],nums[1]);
     * 如果有i个房子，此时的最大值是要第i个，以及不要第i个，于此对应的就是
     */
    public int rob(int[] num) {
        int prevMax = 0; //
        int currMax = 0;
        for (int x : num) {
            int temp = currMax;
            currMax = Math.max(prevMax + x, currMax); //pre记录的是
            prevMax = temp;
        }
        return currMax;
    }

    /**输入:
     nums1 = [1,2,3,0,0,0], m = 3
     nums2 = [2,5,6],       n = 3
     输出: [1,2,2,3,5,6]
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //找到Nums2中小的元素，插入到nums1的头部
        //采用双指针，每插入一个元素将Nums1的元素后移一步。
        int i = 0;
        int j = 0;
    }

}
