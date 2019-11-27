import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * 说明: 叶子节点是指没有子节点的节点。
 * 输入:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 */
public class Lc257 {
    public static void main(String[] args) {


    }

    /**
     * 二叉树遍历所有的叶子节点。
     */
    List<String> list = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null)
            return list;
        String str = new String();
        path(root,str,list);
        return list;
    }

    /**
     * 计算路径：
     */
    public void path(TreeNode root,String str,List<String>list) {
        if (root==null) //根节点为空
            return;
        //根节点不为空，则需要将根节点加进去。
        str = str + root.val;
        //在根节点不为空的情况下，左右节点均为空，此时列表需要增加
        if (root.left == null && root.right == null) //遇到叶子节点：需要将字符串加到列表中
        {
            list.add(str);
        }
        //还没到叶子节点的话，需要接着上面的字符串继续进行递归
        else{ //否则的话继续添加
            path(root.left,str+"->",list);
            path(root.right,str+"->",list);
        }
    }

    public List<String> binaryTreePaths1(TreeNode root) {
        List<String> ret = new ArrayList<>();
        if(root==null) return ret;
        solve1(root, "", ret);
        return ret;
    }

    public void solve1(TreeNode root, String cur, List<String> ret){
        if(root==null) return;
        cur += root.val;
        if(root.left==null&&root.right==null){
            ret.add(cur);
        }else{
            solve1(root.left, cur+"->", ret);
            solve1(root.right, cur+"->", ret);
        }
    }

}
