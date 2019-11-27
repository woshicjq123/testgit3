import sun.util.resources.cldr.zh.CalendarData_zh_Hans_HK;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Lc64 {
    public static void main(String[] args) {
        String str = "cc";
        int[][] nums = {{0,0,0},{0,0,0}};
        int sr = 0;
        int sc = 0;
        int newcolor = 2;
        nums = floodFill(nums, sr, sc, newcolor);
      // System.out.println(firstUniqChar(str));
    }

    public int minPathSum(int[][] grid) {
        if (grid == null)
            return 0;
        int hang = grid.length;
        int lie = grid[0].length;
        int[][] res = new int[hang][lie];
        res[0][0] = grid[0][0];
        for (int i = 1; i < hang; i++) {
            res[i][0] = res[i-1][0]+grid[i][0];
        }
        for (int i = 1; i < lie; i++) {
            res[0][i] = res[0][i-1]+grid[0][i];
        }

        for (int i = 1; i < hang; i++) {
            for (int i1 = 1; i1 < lie; i1++) {
                res[i][i1] = Math.min(res[i-1][i1]+grid[i][i1],res[i][i1-1]+grid[i][i1]);
            }
        }
        return res[hang-1][lie-1];
    }

    public static int numDecodings(String s) {
        if (s==null)
            return 0;
        char[] array = s.toCharArray();
        if (array[0]=='0')
            return 0;
        int first = 1;
        int second = first;
        int cur = second;
        for (int i = 1; i < array.length; i++) {
            if (array[i]=='0' && (array[i-1]>='3'||array[i-1]=='0'))
                return 0; //不在范围内
            if (array[i]=='0' && (array[i-1]=='1'||array[i-1]=='2')) {
                cur = first;  //在范围内的,只可以跟前一个合并起来
                first = 0;
                second = cur;
            }
            else if ((array[i-1]=='2'&&array[i]<='6')||(array[i-1]=='1'&&array[i]<='9')){
                if(i==1) {
                    second = 2;
                    cur = second;
                }
                else {
                    cur = second + first;
                    first = second;
                    second = cur;
                }
            } //可以跟前面的合并，且不是特殊值
            else {
                if (i==1) {
                    second = first;
                    cur = second;
                }
                else{
                    cur = second;
                    first = second;
                }
            }
        }
        return cur;
    }

    public void reverseString(char[] s) {
        if(s==null || s.length<=1)
            return;
        char temp = 0;
        int left = 0;
        int right = s.length-1;
        while (left < s.length && left<right){
            temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

    public static int firstUniqChar(String s) {
        if (s==null||s.length()==0)
            return -1;
        if (s.length()==1)
            return 0;
        int i = 0;
        char[] array = s.toCharArray();
        while (i<array.length){
            if (s.indexOf(array[i],0)!=i)
                return array[i];
            else
                i++;
        }
        return -1;
    }
    HashMap<Integer,Employee> hashMap = new HashMap<>();
    public int getImportance(List<Employee> employees, int id) {
        for (Employee employee:employees){
            hashMap.put(employee.id,employee);
        }
        int sum = 0;
       return dfs(hashMap.get(id));
    }

    public int dfs(Employee employee){
        if (employee.subordinates.size()==0)
            return 0;
        else{
            int sum = employee.importance;
            for (int i = 0; i < employee.subordinates.size(); i++) {
                sum +=  dfs(hashMap.get(employee.subordinates.get(i)));
            }
            return sum;
        }
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int hang = image.length;
        int lie = image[0].length;
        int originColor = image[sr][sc];
        boolean[][] flag = new boolean[hang][lie];
        paint(image, flag, sr, sc, originColor, newColor);
        return image;
    }

    public static void paint(int[][] image, boolean[][]flag, int sr, int sc, int originColor,int newColor) {
        if (image[sr][sc] == originColor && flag[sr][sc] == false) {
            image[sr][sc] = newColor;
            flag[sr][sc] = true;
            if (sr - 1 >= 0)
                paint(image, flag, sr - 1, sc, originColor, newColor);
            if (sc - 1 >= 0)
                paint(image, flag, sr, sc - 1, originColor, newColor);
            if (sr + 1 < image.length)
                paint(image, flag, sr + 1, sc, originColor, newColor);
            if (sc + 1 < image[0].length)
                paint(image, flag, sr, sc + 1, originColor, newColor);
        }
    }



    public int depth(Node root) {
        if(root == null)
            return 0;
        int curMax = 0;
        for (int i = 0; i < root.children.size(); i++) {
            curMax = Math.max(curMax,depth(root.children.get(i)));
        }
         return curMax+1;
    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if (root1==null && root2==null)
            return true;
        if (root1==null)
            return false;
        if (root2==null)
            return false;
        List<TreeNode> list1 = new LinkedList<>();
        list1 = leaf(root1,list1);
        List<TreeNode> list2 = new LinkedList<>();
        list2 = leaf(root2,list2);
        if (list1.size() != list2.size())
            return false;
        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i).val!=list2.get(i).val){
                return false;
            }
        }
        return true;
    }

    public List<TreeNode> leaf(TreeNode root,List<TreeNode> list) {
        if (root.left==null && root.right==null){
            list.add(root);
        }
        list = leaf(root.left,list);
        list = leaf(root.right,list);
        return list;
    }
}
