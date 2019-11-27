import java.util.Deque;
import java.util.LinkedList;

/**
 *将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *
 * 给定有序数组: [-10,-3,0,5,9],
 *
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 */
public class Lc108 {
    public static void main(String[] args) {
        int[] nums = {-10,-3,0,5,9};
        TreeNode root = sortedArrayToBST(nums);
        System.out.println(root.val);
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        return nums == null ? null : buildBST(nums, 0, nums.length - 1);
    }

    public static TreeNode buildBST(int[] nums,int l,int r) {
        if (l>r)
            return null;
        int mid = l+(r-1)/2;
        System.out.println(mid);
        int m = l + (r - l) / 2;
        System.out.println(m);
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildBST(nums,l,mid-1);
        root.right = buildBST(nums,mid+1,r);
        return root;
    }

    public static TreeNode sortedArrayToBST1(int[] nums) {
        // 左右等分建立左右子树，中间节点作为子树根节点，递归该过程
        return nums == null ? null : buildTree1(nums, 0, nums.length - 1);
}

    private static TreeNode buildTree1(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }
        int m = l + (r - l) / 2;
        TreeNode root = new TreeNode(nums[m]);
        root.left = buildTree1(nums, l, m - 1);
        root.right = buildTree1(nums, m + 1, r);
        return root;
    }
}
