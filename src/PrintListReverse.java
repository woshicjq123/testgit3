import java.util.List;
import java.util.Stack;

public class PrintListReverse {
    public static void main(String[] args) {

    }
//从尾到头打印链表 从尾到头采用栈的数据结构
    public static void printListReverse(ListNode head){
        if (head==null)
            return;
        if (head.next == null)
            System.out.println(head.val);
        Stack<Integer> stack = new Stack<>();
        while (head!=null){
            stack.push(head.val);
            head = head.next;
        }
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }

    public static void printReverse(ListNode head){
        //递归实现链表从尾到头输出
        if (head.next != null)
            printListReverse(head.next);
        if (head != null){
            System.out.println(head.val);
        }
    }
}
