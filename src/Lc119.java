import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Lc119 {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        list = getRow(3);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> nums = new LinkedList<>();
        if (rowIndex<0)
            return nums;
        nums.add(1);
        int temp = 0;
        int oldTemp = 0;
        if (rowIndex==0)
            return nums;
        nums.add(1);
        if (rowIndex==1)
            return nums;
       // if (nums.size())
        for (int i = 1; i < rowIndex; i++) {//
            oldTemp = nums.get(0);
            for (int i1 = 1; i1 <= i; i1++) {//
                temp = nums.get(i1);
                nums.set(i1,oldTemp+nums.get(i1));
                oldTemp = temp;
            }
            nums.add(1);
        }
        return nums;
    }
}
