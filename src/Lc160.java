import java.util.Objects;

/**
 * 编写一个程序，找到两个单链表相交的起始节点。
 * 如下面的两个链表：
 *
 * 获取相交节点：
 * 1）如果其中一个链表为Null,name肯定不相交。
 * 2）遍历求解两个链表的长度len1 len2，注意标记那个长那个短
 * 3)从长的那个链表的第len1-len2个元素开始
 * 4）如果next指向相同那么返回节点的val.
 * 5)如果两个链表都指向了Null，则返回Null。
 *
 */
public class Lc160 {
    public static void main(String[] args) {

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0;
        int lenB = 0;
        if (headA == null||headB==null)
            return null;
        ListNode curA = headA;
        ListNode curB = headB;
        while (curA!=null){
            lenA++;
            curA = curA.next;
        }

        while (curB!=null){
            lenB++;
            curB = curB.next;
        }
        //保证让curA指向的是长的那个,lenA是长的那个；
        if (lenA<lenB){
            int temp = lenA;
            lenA = lenB;
            lenB = temp;
            curA = headB;
            curB = headA;
        }
        else{
            curA = headA;
            curB = headB;
        }
        int i = 0;
        while (i<lenA - lenB){
            curA = curA.next;
            i++;
        }

        while (curA!=null && curB!=null && curA!=curB){
            curA = curA.next;
            curB = curB.next;
        }

        if (curA==null && curB==null){
            return null;
        }
        return curA;
    }
}
