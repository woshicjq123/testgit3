public class CheckLoop {
    public static void main(String[] args) {

    }
    //寻找两个链表的交叉节点
    public static ListNode checkLoop(ListNode head1,ListNode head2){
        if (head1==null || head2==null)
            return null;
        ListNode temp1 = head1;
        ListNode temp2 = head2;
        int len1 = 0;
        int len2 = 0;
        while (temp1!=null){
            len1++;
            temp1 = temp1.next;
        }
        while (temp2!=null){
            len2++;
            temp2 = temp2.next;
        }

        if (len1 < len2){
            for (int i = 0; i < len2 - len1; i++) {
                head2 = head2.next;
            }
            while (head1!=head2){
                head1 = head1.next;
                head2 = head2.next;
            }
        }
        else
        {
            for (int i = 0; i < len1 - len2; i++) {
                head1 = head1.next;
            }
            while (head1!=head2){
                head1 = head1.next;
                head2 = head2.next;
            }
        }
        return head1;
    }
}
