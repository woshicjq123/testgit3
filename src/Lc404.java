/**
 * 计算给定二叉树的所有左叶子之和。
 *
 * 示例：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 */
public class Lc404 {
    public static void main(String[] args) {

    }

    /**
     * 遍历所有的左孩子。
     */
    int sum;
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null)
            return 0;
        sumLeaf(root);
        return sum;
    }

    public void sumLeaf(TreeNode root) {
        if (root == null) //当根为空
            return;
        if (root.left== null) //根不为空，左孩子为空
            sumLeaf(root.right);
        else
        {
            if (root.left.left==null && root.left.right == null){
                sum = sum + root.left.val; //左孩子不为空，且左孩子为叶子节点
                sumLeaf(root.right);
            }
            else {
                sumLeaf(root.left);
                sumLeaf(root.right);
            }
        }
    }
}
