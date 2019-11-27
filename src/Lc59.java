public class Lc59 {
    public static void main(String[] args) {
        int n = 3;
        int[][]nums = generateMatrix(n);
        for (int i = 0; i < n; i++) {
            for (int i1 = 0; i1 < n; i1++) {
                System.out.println(nums[i][i1]);
            }
            System.out.println(" ");
        }
    }
    public static int[][] generateMatrix(int n) {
        int max = n*n;
        int[][]res = new int[n][n];

        int cur = 1;
        while (cur<=max) {
            ;
        }
        return res;
    }


}
