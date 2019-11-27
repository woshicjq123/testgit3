/**
 * 反转一个单链表。
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *
 *  链表反转也就相当于是交换 cur.next 以及cur.next.next的指向
 *  1）如果链表为空，那么返回Null
 *  2）如果链表长度为1，那么返回head
 *  3）如果长度等于2，也可以简单操作
 *  3）链表长度大于等于3，那么 behind1 = head.next ; head.next = null; behind2 = behind1.next;
 *  behind1.next = head;
 *
 *  if (behind2 == null) return behind1;
 *  else{
 *  if (behind2.next == null)
 *      behind3 = behind2.next;
 *   else
 *  }
 *
 *
 */
public class Lc206 {
    public static void main(String[] args) {

    }

    public ListNode reverseList(ListNode head) {
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
