

public class Lc415 {
    public static void main(String[] args) {
        String s1 = "99";
        String s2 = "9";
        //char[] s3 = {'1','0'};
        //System.out.println((char)(1+'0'));
       // System.out.println(String.valueOf(s3));
        System.out.println(addStrings(s1,s2));
    }

    public static String addStrings(String num1, String num2) {
        if (num1 == null || num1.length()==0)
            return num2;
        if (num2==null||num2.length()==0)
            return num1;
        char[] array1;
        char[] array2;
    if (num1.length()<num2.length()){
        array1 = num1.toCharArray();
        array2 = num2.toCharArray();
    }
    else{
        array1 = num2.toCharArray();
        array2 = num1.toCharArray();
    }
    int jw = 0;
    int cur = 0;
    //LinkedList<Integer> list = new LinkedList<>();
        for (int i = array1.length-1; i >= 0; i--) {
        cur = array1[i]-'0' + array2[i+array2.length - array1.length]-'0'+jw;
        jw = cur / 10;
        cur = cur % 10;
        array2[i+array2.length - array1.length] = (char)(cur +'0');
    }
        if (jw ==0)
            return String.valueOf(array2);
        for (int i = array2.length - array1.length-1;i>=0;i--){
            cur = array2[i]-'0'+jw;
            jw = cur / 10;
            array2[i] = (char)(cur % 10+'0');
            if (jw==0)
                break;
    }
        if (jw!=0)
        {
            return "1"+ String.valueOf(array2);
        }
        else
            return String.valueOf(array2);
    }
}
