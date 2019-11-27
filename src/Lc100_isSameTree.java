import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Lc100_isSameTree {
    public static void main(String[] args) {

    }

    /**
     * 在每一层出队的时候将孩子节点入队
     * 当根节点为空的时候，将list返回
     * 1）当根节点不为空的时候，将节点首先入队，计算此时队列的长度
     * 2）新建list，该List是存储这一层的List。对于位于队列中的节点，使其出队，队列长度减一
     */
    /*
    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root==null)
            return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<List<Integer>> arrayList = new ArrayList<>();
        while (!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int count = queue.size();
            while (count!=0){
                TreeNode temp = queue.peek();
                queue.poll();
                list.add(temp.val);
                queue.offer(temp.left);
                queue.offer(temp.right);
                count--;
            }
            arrayList.add(list);
            //arrayList
        }
        return arrayList;
    }

    /**
     * 用栈，根节点为空，则返回list
     *  当根节点不为空，根节点入栈，记录
     */
    /*
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> linkedList = new LinkedList<>();
        if (root== null)
            return linkedList;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            LinkedList<Integer> list = new LinkedList<>();
            int count = queue.size();
            while (count>0){
                TreeNode temp = queue.peek();
                queue.poll();
                list.add(temp.val);
                if (temp.left!=null)
                    queue.offer(temp.left);
                if (temp.right!=null)
                    queue.offer(temp.right);
                count--;
            }
            linkedList.addFirst(list);
        }
        return linkedList;
    }

    /**
     *

    public static TreeNode invertTree(TreeNode root) {

    }
*/
}
