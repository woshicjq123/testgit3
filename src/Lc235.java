import java.util.LinkedList;

/**
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 *
 *
 */
public class Lc235 {
    public static void main(String[] args) {

    }

    /**
     * 注意前提条件是二叉搜索树，所以其节点路径也就唯一
     */

    /**
    二叉搜索树的特性： 二叉搜索树中的任意两个节点，其均可以通过一个共同父节点分割在二叉搜索树的两侧。
     */
    public static TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (p.left == q || p.right == q)
            return p;
        if (q.left == p || q.right == p)
            return q;
        LinkedList<TreeNode> l1 = lowestCommonAncestor(root,p);
        LinkedList<TreeNode> l2 = lowestCommonAncestor(root,q);
        // 将问题转换为从
        TreeNode commonAncestor = root;
        int time = Math.min(l1.size(),l2.size());
        for (int i = 1; i < time; i++) {
            for (int i1 = 1; i1 < time; i1++) {
                if (l1.get(i) == l2.get(i1))
                    commonAncestor = l1.get(i);
            }
        }
        return commonAncestor;

    }
    public static LinkedList<TreeNode> lowestCommonAncestor(TreeNode root, TreeNode p) {
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        while (root.val != p.val){
            linkedList.add(root);
            if (root.val<p.val){
                root = root.right;
            }
            else
                root = root.left;
        }
        linkedList.add(root);
        return linkedList;
    }
    TreeNode res = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        commonAncestor(root,p,q);
        return res;
    }

    public void commonAncestor(TreeNode root,TreeNode p, TreeNode q){
        if ((root.val - p.val) * (root.val-q.val)<0) {
            res = root;
        }
        else if ((root.val<p.val)&&(root.val<q.val)){
            commonAncestor(root.right,p,q);
        }
        else
            commonAncestor(root.left,p,q);
    }

}
