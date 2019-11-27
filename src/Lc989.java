import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Lc989 {
    public static void main(String[] args) {

    }

    public List<Integer> addToArrayForm(int[] A, int K) {
        LinkedList<Integer> list = new LinkedList<>();
        int jw = 0;
        int len2 = String.valueOf(K).length(); //求出K的长度
        int[] B = new int[len2]; //
        int[] C = B;
        int k = 1;
        while (K>0){
            B[len2 - k] = K%10;
            k++;
            K = K/10;
        } //将K转换成数组

        //要求出哪个数组是最长的
        int len1 = A.length;
        if (len1 < len2) //确保Len1是最长的
        {
            C = A;
            A = B;
            B = C;
            int temp = len1;
            len1 = len2;
            len2 = temp;
        }
        int cur = 0;
        int jinw = 0;
        for (int i = len2-1; i >= 0; i--) {
            cur = B[i]+A[i+len1-len2]+jinw;
            jinw = cur/10;
            cur = cur%10;
            list.addFirst(cur);
        }
        if (len1 == len2 && jinw != 0){
            list.addFirst(jinw);
            return list;
        }
        else if (len1 == len2 && jinw == 0){
            return list;
        }
        else
        {
            for (int i = len1 - len2-1; i >=0 ; i--) {
                cur = A[i] + jinw;
                jinw = cur/10;
                cur = cur%10;
                list.addFirst(cur);
            }
            if (jinw == 0)
                return list;
            else
            {
                list.addFirst(jinw);
                return list;
            }
        }
    }

    public List<Integer> addToArrayForm1(int[] A, int K) {
        int N = A.length;
        int cur = K;
        List<Integer> ans = new ArrayList<>();

        int i = N;
        while (--i >= 0 || cur > 0) {
            if (i >= 0)
                cur += A[i];
            ans.add(cur % 10);
            cur /= 10;
        }
        Collections.reverse(ans);
        return ans;
    }

}
