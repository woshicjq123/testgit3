import sun.awt.image.ImageWatched;

import java.util.List;

public class FindK {
    public static void main(String[] args) {
    }

    /**
     *
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        //考虑n的合法性
        if (n<0)
            return null;
        if (head==null)
            return null;
        ListNode temp=head;
        ListNode pre=head;
        //先让pre走k-1步
        for (int i = 1; i < n ; i++) {
            if (pre.next!=null)
                pre = pre.next;
            else
                return null; //如果长度小于k那么倒数k个元素是无效的，因此返回null
        }
        //此时长度一定大于k
        while (pre!=null) {
            temp = temp.next;
            pre = pre.next;
        }
        return temp;
    }
}
