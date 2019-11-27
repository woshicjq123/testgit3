import java.util.HashSet;

/**
 * 给定一个链表，判断链表中是否有环。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 * 示例 1：
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 * 如果链表为空，则返回false
 *
 * 对于当前的每一个节点，都需要对之后的节点进行遍历，判断后面的节点的next究竟是不是指向但概念节点(while)
 *
 */
public class Lc141 {
    public static void main(String[] args) {
        ListNode l1 =new  ListNode(1);
        ListNode l2 =new  ListNode(2);
        ListNode l3 =new  ListNode(1);
        l1.next = l2;
        l2.next = l3;
        l3.next = l1;
        System.out.println(hasCycle(l1));
    }
    //将节点存在hashset中，如果有重复的那么就是有环的。
    public static boolean hasCycle(ListNode head) {
        if (head == null)
            return false;
        HashSet<ListNode> set = new HashSet<>();
        set.add(head);
        ListNode cur = head.next;
        if (cur==null)
            return false;
        while (!set.contains(cur)){
            set.add(cur);
            cur = cur.next;
            if (cur == null)
                return false;
        }
        return true;
    }
}
