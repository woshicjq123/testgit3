import java.util.ArrayList;
import java.util.List;

public class Lc118 {
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        list = generate(5);
        for (int i = 0; i < list.size(); i++) {
            for (int i1 = 0; i1 < list.get(i).size(); i1++) {
                System.out.print(list.get(i).get(i1)+" ");
            }
            System.out.println("");
        }
    }
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        //对于每个list的每个元素都是list。
        //List<Integer> childList = new ArrayList<>();
        if (numRows <=0)
            return list;
        for (int i = 0; i < numRows; i++) {
            List<Integer> childList = new ArrayList<>();
            if (i==0) {
                childList.add(1);
                list.add(childList);
            }
            else{
                for (int i1 = 0; i1 <= i; i1++) {  //
                    if (i1==0 || i1 == i)
                        childList.add(1);
                    else{
                        childList.add(list.get(i-1).get(i1)+list.get(i-1).get(i1-1));
                    }
                }
                list.add(childList);
            }
        }
        return list;
    }
}
