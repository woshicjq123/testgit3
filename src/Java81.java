import java.util.Hashtable;

public class Java81 {
    public static Linknode deleteDuplicate(Linknode l1){
        if (l1==null || l1.next == null)
            return l1;
        Linknode temp = l1;
        Linknode head = l1;
        Hashtable<Integer,Integer> hashtable = new Hashtable<>();
        while (l1.next !=null){
            if (hashtable.contains(l1.next.val)){
                temp = l1;
                if (l1.next.next !=null)
                    temp.next = l1.next.next;
                else
                    temp.next = null;
            }
            else
                hashtable.put(l1.val,l1.val);
            if (l1.next != null)
                l1 = l1.next;
        }
        return head;
    }
    public static void main(String[] args) {
        Linknode l1 = new Linknode(1);
        Linknode l2 = new Linknode(2);
        Linknode l3 = new Linknode(2);
        Linknode l4 = new Linknode(4);
        Linknode l5 = new Linknode(1);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = null;
        Linknode temp = deleteDuplicate(l1);
        while (temp!=null){
            System.out.println(temp.val);
            temp = temp.next;
        }

    }

}
