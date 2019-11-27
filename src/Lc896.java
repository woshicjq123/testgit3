public class Lc896 {
    public static void main(String[] args) {

    }

    public boolean isMonotonic(int[] A) {
        if (A.length==0||A.length==1||A==null)
            return true;
        int i = 1;
        int sign = 0;
        int j = 0;
        while (j<A.length-1 && A[j]==A[j+1]){
            j++;
        }
        if (j==A.length)
            return true;
        if (A[j] < A[j+1])
            sign = 1;
        int oldsign = sign;
        while (i<A.length-1){
            oldsign = sign;
            if (A[i] < A[i+1])
                sign = 1;
            else if (A[i]==A[i+1])
                sign = oldsign;
            else
                sign = 0;
            if (oldsign != sign)
                return false;
            i++;
        }
        return true;
    }
}
