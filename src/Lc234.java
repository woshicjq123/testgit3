import java.util.ArrayList;

/**
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 */
public class Lc234 {
    public static void main(String[] args) {
        ListNode l1 =new  ListNode(3);
        ListNode l2 =new  ListNode(2);
        ListNode l3 =new  ListNode(3);
        l1.next = l2;
        l2.next = l3;
        l3.next = null;
        System.out.println(isPalindrome(l1));
    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;
        ArrayList<Integer> array = new ArrayList<>();
        while (head!=null){
            array.add(head.val);
            head = head.next;
        }

        ListNode head1 = reverseList(head);
        int i = 0;
        while (head1!=null){
            if (array.get(i) != head1.val)
                return false;
            else{
                head1 = head1.next;
                i++;
            }
        }
        return true;
    }

    public static ListNode reverseList(ListNode head) {
        ListNode behind1 = head;
        ListNode behind2 = head;
        ListNode behind3 = head;
        if (head == null||head.next ==null)
            return head;
        //下面属于长度大于等于2的，改变头节点
        behind1 = head.next;
        head.next = null;
        behind2 = behind1.next;
        behind1.next = head;
        if (behind2 == null) //只有两个节点
            return behind1;
        else{ //有三个节点
            while (behind2!=null) {
                if (behind2.next == null) {
                    behind2.next = behind1;
                    return behind2;
                }
                //大于三个节点的
                else {
                    behind3 = behind2.next;
                    behind2.next = behind1;
                    behind1 = behind2;
                    behind2 = behind3;
                }
            }
        }
        return behind2;
    }
}
