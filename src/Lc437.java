import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树，它的每个结点都存放着一个整数值。
 *
 * 找出路径和等于给定数值的路径总数。
 *
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 *
 * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
 *
 * 示例：
 *
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 *
 *       10
 *      /  \
 *     5   -3
 *    / \    \
 *   3   2   11
 *  / \   \
 * 3  -2   1
 *
 * 返回 3。和等于 8 的路径有:
 *
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3.  -3 -> 11
 */

public class Lc437 {
    int total;
    public static void main(String[] args) {

    }

    /**
     * 递归从上到下，考虑每一个节点，该几点到子节点中是否存在符合条件的，可能
     * 到某个子节点就已经符合条件，这时候++,同时继续进行递归。因此需要些一个程序是关于从某个节点
     * 开始是否存在符合条件的。还有一个是些要不要从这个节点开始。
     */
    public int pathSum(TreeNode root, int sum) {
        if (root==null)
            return 0;
        pathReverse(root,sum);
        pathSum(root.left,sum);
        pathSum(root.right,sum);

        return total;
    }
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        if (digits[len-1]<9){
            digits[len-1]++;
            return digits;
        }
        else{
            LinkedList<Integer> list = new LinkedList<>();
            int jw = 0;
            for (int i = 0; i < digits.length; i++) {
                list.add((digits[i]+1+jw)%10);
                jw = (digits[i]+1)/10;
            }
            if (jw==1)
                list.addFirst(jw);
            int[] res = new int[list.size()];
            for (int i = 0; i < res.length; i++) {
                res[i] = list.get(i);
            }
            return res;
        }
    }

    public void pathReverse(TreeNode root,int sum){
        if (root==null)//根节点为空，这时候不可能了
            return;
        if (sum - root.val == 0) //根节点恰好等于sum，这时候需要+1
        {
            total++;
        }
        pathReverse(root.left,sum - root.val);
        pathReverse(root.right,sum - root.val);
    }
}
