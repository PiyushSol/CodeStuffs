public class GridPath {
    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i=0;i<n;i++){
            dp[0][i]=1;
        }
        for(int i=0;i<m;i++){
            dp[i][0] =1;
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

    public int helper(int row,int col , int m ,int n,int dp[][]){
        if(row ==m-1 && col==n-1){
            return 1;
        }
        if(row>=m||col>=n){
            return 0;
        }

        if(dp[row][col]!=0){
            return dp[row][col];
        }

        int downWays = helper(row+1,col,m,n,dp);
        int rightWays =helper(row,col+1,m,n,dp);
        return dp[row][col]=rightWays+downWays;
    }

    public static void main(String[] args) {
        int m =3 ,n=7;
        System.out.println(uniquePaths(m,n));
    }
}
