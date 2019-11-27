public class Lc63 {
    public static void main(String[] args) {

    }
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int hang = obstacleGrid.length;
        int lie = obstacleGrid[0].length;
        if (obstacleGrid == null)
            return -1;
        if (obstacleGrid[0][0]==1)
            return 0;
        if (obstacleGrid[hang-1][lie-1]==1)
            return 0;
        if (hang <=1 || lie<=1)
            return 1;
        int[][] res = new int[hang][lie];
        res[0][0] = 1;
        for (int i = 1; i < hang; i++) {
            if (obstacleGrid[i][0]==0)
                res[i][0] = res[i-1][0];
            else
                res[i][0] = 0;
        }
        for (int i = 1; i < lie; i++) {
            if (obstacleGrid[0][i]==0)
                res[0][i] = res[0][i-1];
            else
                res[0][i] = 0;
        }
        for (int i = 1; i < hang; i++) {
            for (int i1 = 1; i1 < lie; i1++) {
                if (obstacleGrid[i][i1]==0)
                    res[i][i1] = res[i][i1-1] + res[i-1][i1];
                else
                    res[i][i1] = 0;
            }
        }
        return res[hang-1][lie-1];
    }

}
