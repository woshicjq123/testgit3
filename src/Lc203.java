import java.util.List;

/**
 * 删除链表中等于给定值 val 的所有节点。
 * 示例:
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 *
 * 如果链表为空，则返回null
 * 如果链表head.next = null,则如果相等，那么head = null,否则的话返回head
 * 如果链表长度大于1，定义两个指针 front cur，
 * front是第一个不等于val的，
 * cur是从front的下一个开始
 */
public class Lc203 {
    public static void main(String[] args) {
        ListNode l1 =new  ListNode(3);
        ListNode l2 =new  ListNode(2);
        ListNode l3 =new  ListNode(2);
        l1.next = l2;
        l2.next = l3;
        l3.next = null;
        System.out.println(removeElements(l1,3).val);
    }
    public static ListNode removeElements(ListNode head, int val) {
        ListNode front = head;
        ListNode cur = head;
        ListNode head_bk = head;
        while (head!=null){
            if (head.val!= val){//找到一个不相等的
                front = head;
                head_bk = head;
                break;
            }
            head = head.next;
        }
        if (head == null)//所有节点都等于val
            return null;
        else{
            cur = head.next;
            while (cur!=null){
                //找到后面第一个不等于val的
                while (cur!= null && val== cur.val){
                    cur = cur.next;
                }
                if (cur==null){
                    front.next = null;
                    return head_bk;
                }
                else{
                    front.next = cur;
                    front = cur;
                    cur = cur.next;
                }
            }
        }
        return head_bk;
    }
}
