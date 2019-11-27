import java.util.List;

/**
 *给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * 示例 1:
 *
 * 输入: 1->1->2
 * 输出: 1->2
 *
 *
 * 示例 2:
 *
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 *
 * 定义两个引用，一个引用指向当前节点，一个引用指向未重复节点
 * 如果当前节点一直等于未重复节点，则next，直到找到一个不相等的（while）
 * 这时候将为重复节点的next指向当前节点，然后继续循环，直到链表遍历完成。
 * 如果链表遍历完成以后，未重复节点等于当前最后节点，那么结束。否则，我们需要将未重复节点的next指向空。
 */
public class Lc83 {
    public static void main(String[] args) {
        ListNode l1 =new  ListNode(1);
        ListNode l2 =new  ListNode(1);
        ListNode l3 =new  ListNode(2);
        ListNode l4 =new  ListNode(3);
        ListNode l5 =new  ListNode(3);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = null;
        ListNode head = deleteDuplicates(l1);
        while (head!=null){
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head==null||head.next==null) //即链表为空或者链表只有一个节点。
            return head;
        ListNode cur = head.next;
        ListNode front = head;
        while (cur!=null){
            while (cur!=null && front!=null && cur.val == front.val){
                cur = cur.next;
            }
            front.next = cur;
            front = cur;//将当前的未重复节点进行更新
            if (cur !=null)
                cur = cur.next;
        }
        return head;
    }


}
