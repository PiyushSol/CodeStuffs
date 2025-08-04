import java.util.ArrayList;
import java.util.List;

public class RatinaMaze {
    public static void main(String[] args) {
        int [][] grid = new int[][]{
                {1,0,0,0},
                {1,1,0,1},
                {1,1,0,0},
                {0,1,1,1}
        };
        System.out.println(findPath(grid));
    }

    public static List<String> findPath(int[][] grid) {
         List<String>ans = new ArrayList<>();
         boolean[][] visited = new boolean[grid.length][grid.length];
         if(grid[0][0]==1){
             solve(0,0,grid,ans,visited,"",grid.length);
         }
         return ans;
    }

    public static void solve(int i, int j,int[][]grid ,List<String> ans ,boolean[][]visited,String move, int n){
        if(i==n-1 && j==n-1){
            ans.add(move);
            return;
        }
        visited[i][j]=true;

        if (i + 1 < n && !visited[i + 1][j] && grid[i + 1][j] == 1) {
            solve(i + 1, j, grid, ans, visited, move + "D", n);
        }


        if (j - 1 >= 0 && !visited[i][j - 1] && grid[i][j - 1] == 1) {
            solve(i, j - 1, grid, ans, visited, move + "L", n);
        }

        if (j + 1 < n && !visited[i][j + 1] && grid[i][j + 1] == 1) {
            solve(i, j + 1, grid, ans, visited, move + "R", n);
        }

        if (i - 1 >= 0 && !visited[i - 1][j] && grid[i - 1][j] == 1) {
            solve(i - 1, j, grid, ans, visited, move + "U", n);
        }

        visited[i][j]=false;
    }


}
