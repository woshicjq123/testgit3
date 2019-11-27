import java.util.Stack;

public class Lc1221 {
    public int balancedStringSplit(String s) {
        Stack<Character> stack = new Stack<>();
        if (s==null || s.length()==0||s.length()==1)
            return 0;
        stack.push(s.charAt(0));
        int i = 1;
        int count = 0;
        while (i<=s.length()){
            if (stack.isEmpty())
            {
                count++;
                if (i<s.length())
                    stack.push(s.charAt(i));
                else
                    return count;
                i++;
            }
            else{
                if (isMatch(s.charAt(i),stack.peek()))
                {
                    stack.pop();
                }
                else{
                    stack.push(s.charAt(i));
                }
                i++;
            }
        }
        return count;

    }

    public boolean isMatch(char ch1,char ch2){
        if (ch1 =='L'&& ch2=='R')
            return true;
        if (ch1 =='R'&& ch2=='L')
            return true;
        return false;
    }
}
