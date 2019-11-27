/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 *
 *
 * 示例 1:
 *
 * 给定二叉树 [3,9,20,null,null,15,7]
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 返回 true 。
 *
 * 示例 2:
 *
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * 返回 false 。
 */
public class Lc110 {
    public static void main(String[] args) {

    }

    /**
     * 当左右子树的高度超过范围，则标志位为false。这个时候就不需要递归了，直接就返回。
     * 当左右子树高度没超过范围，则标志位为true，这时候继续递归，返回的是树的实际高度
     */
    boolean flag= true;
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        if (root.left == null && root.right==null)
            return true;
        int height = 1;
        height = height(root,height);
        return flag;
    }

    public int height(TreeNode root,int height) {
        if (flag == true) {
            if (root == null)
                return (height);
            int leftHeight = height + 1;
            int rightHeight = height + 1;
            leftHeight = height(root.left, leftHeight);
            rightHeight = height(root.right, rightHeight);
            if(Math.abs(leftHeight-rightHeight)>1) flag=false;
            return (leftHeight < rightHeight ? rightHeight : leftHeight);
        }
        else
            return height;
    }
}
