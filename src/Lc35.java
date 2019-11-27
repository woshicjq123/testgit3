import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

import static java.util.Arrays.*;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 你可以假设数组中无重复元素。
 *
 * 首先二分查找，查找该元素究竟有没有，所以需要一个标志位
 * 如果标志位显示没找到，那么这个时候返回的下标就是它应该插入的位置，所以这道题其实就是二分查找
 */
public class Lc35 {
    public static void main(String[] args) {
        int[] nums ={1,3,5,6};
        System.out.println(searchInsert(nums,2));
    }

    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int mid = 0;
        if (nums == null)
            return -1;
        while (left < right){
            mid = (left+right)/2;
            if (nums[mid]==target)
            {
                return mid;
            }
            else if (nums[mid]<target){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        if (nums[left]<target)
            return left+1;
        else
            return left;
    }
}