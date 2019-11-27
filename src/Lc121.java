public class Lc121 {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;

    }

    public static int maxProfit(int[] prices) {
        //从两边同时找，左边找最小值，右边找最大值
        if (prices==null||prices.length<=1)
            return 0;
        int min = prices[0];
        int i = 1;
        //找到第一个可能出现盈利的位置
        while (min > prices[i] && i<prices.length){
            min = prices[i];
            i++;
        }
        if (i==prices.length)
            return 0;
        min = prices[i-1];
        int profit = 0;
        //每次多遍历一个元素，需要更新当前的最小值，以及盈利
        while (i <prices.length){
            profit = Math.max(prices[i]-min,profit);
            min = Math.min(min,prices[i]);
            i++;
        }
        if (profit<0)
            return 0;
        else
            return profit;
    }
//不可以重复使用相同元素
}
