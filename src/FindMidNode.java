import java.util.List;

public class FindMidNode {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = null;
        ListNode start = findMid(l1);
        System.out.println(start.val);
    }

    public static ListNode findMid(ListNode head) {
        //寻找中间节点 快慢指针
        if (head == null || head.next==null)
            return head;
        ListNode fast = head;
        ListNode slow = head;
        while (fast!=null){
            if (fast.next!=null)
                fast = fast.next;
            else
                return slow;
            if (fast.next !=null)
                fast = fast.next;
            else
                return slow;
            slow = slow.next;
        }
        return slow;
    }
}
