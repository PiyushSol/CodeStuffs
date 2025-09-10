public class PathWithObstacles {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];

        if (obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1) {
            return 0;
        }
        dp[0][0] = 1;

        for (int j = 1; j < n; j++) {
            if (obstacleGrid[0][j] == 0) {
                dp[0][j] = dp[0][j-1];
            }
        }

        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 0) {
                dp[i][0] = dp[i-1][0];
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }

        return dp[m-1][n-1];
    }

    public static int countWays(int[][] g ,int row, int col,int dp[][]){
        if(row == g.length-1 && col == g[0].length-1){
            return 1;
        }
        if(row >=g.length || col >=g[0].length){
            return 0;
        }
        if(g[row][col]==1)return 0;
        if(dp[row][col]!=-1){
            return dp[row][col];
        }
        int down = countWays(g,row+1,col,dp);
        int right = countWays(g,row,col+1,dp);
        return dp[row][col]=down+right;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {0,0,0},
                {0,1,0},
                {0,0,0}
        };
        System.out.println(uniquePathsWithObstacles(grid));
    }
}
