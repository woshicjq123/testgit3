public class ReverseLinklist {
    public static void main(String[] args) {

    }
    //反转链表
    public static ListNode reverseLinkList(ListNode head){
        if (head==null || head.next == null)
            return head;
        // 1- 2 - 3 - 4
        ListNode front = head;
        ListNode cur = front.next;
        ListNode behind = cur;
        front.next = null;
        while (cur!=null){
            behind = cur.next; //记录下一个元素
            cur.next = front;
            front = cur;
            cur = behind;
        }
        return front;
    }
}
