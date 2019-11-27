public class Lc62 {
    public static void main(String[] args) {
        int[][] nums = {{0,0,0},{0,1,0},{0,0,0}};
       //System.out.println(uniquePathsWithObstacles(nums));
    }

    public int uniquePaths(int m, int n) {
        int[][] res = new int[m][n];
        if (m<=1 || n<=1)
            return 1;
        for (int i = 0; i < m; i++) {
            res[m][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            res[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int i1 = 1; i1 < n; i1++) {
                res[i][i1] = res[i-1][i1]+res[i][i1-1];
            }
        }
        return res[m-1][n-1];
    }
}
