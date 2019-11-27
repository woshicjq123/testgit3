import java.util.Scanner;

public class DeleteNode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m;
        int n;
        m = sc.nextInt();
        n = sc.nextInt();
        System.out.println(m+n);


    }

    public static boolean deleteNode(ListNode node){
        if (node==null || node.next == null)
            return false;
        ListNode behind = node.next;
        node.val = behind.val;
        if (node.next.next != null)
            node.next = node.next.next;
        else
            node.next = null;
        return true;
    }
}
