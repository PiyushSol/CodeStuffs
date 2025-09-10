public class MinPathSum {
    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int dp[][] = new int[m][n];
        dp[0][0] = grid[0][0];

        for (int j = 1; j < n; j++) {
            dp[0][j] = grid[0][j] + dp[0][j - 1];
        }

        for (int i = 1; i < m; i++) {
            dp[i][0] = grid[i][0] + dp[i - 1][0];
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[m-1][n-1];
    }

    public static int minSum(int[][] grid, int r , int c, int m, int n){
        if(r>=m ||c>=n)return Integer.MAX_VALUE;

        if(r==m-1 && c ==n-1){
            return grid[r][c];
        }

        int down = minSum(grid,r+1,c,m,n);
        int right = minSum(grid,r,c+1,m,n);
        return grid[r][c]+Math.min(down,right);
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1,3,1},
                {1,5,1},
                {4,2,1},
        };
        System.out.println(minPathSum(grid));
    }
}
