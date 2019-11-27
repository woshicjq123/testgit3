public class Lc84 {
    public static void main(String[] args) {
        int[] nums = {2,1,5,6,2,3};
        System.out.println(largestRectangleArea(nums));
    }

    public static int largestRectangleArea(int[] heights) {
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            max = Math.max(max,calculateleft(heights,i)+heights[i]+calculateright(heights,i));
        }
        return max;
    }
    public static int calculateleft(int[] heights,int mid) {
        int sum = 0;
        if (mid ==0)
            return sum;
        for (int i = mid - 1; i >= 0; i--) {
            if (heights[i]>=heights[mid])
                sum += heights[mid];
            else
                return sum;
        }
        return sum;
    }

    public static int calculateright(int[] heights,int mid) {
        int sum = 0;
        if (mid == heights.length-1)
            return sum;
        for (int i = mid + 1; i < heights.length; i++) {
            if (heights[mid]<=heights[i])
                sum += heights[mid];
            else
                return sum;
        }
        return sum;
    }

    public static int largestRectangleArea1(int[] heights) {
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            max = Math.max(max,calculateleft(heights,i)+heights[i]+calculateright(heights,i));
        }
        return max;
    }
}
