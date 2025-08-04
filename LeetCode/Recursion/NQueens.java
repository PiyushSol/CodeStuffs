import java.util.*;

public class NQueens {
    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }

    public static List<List<String>> solveNQueens(int n){
        String [][] board =  new String[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]=".";
            }
        }
        List<List<String>>ans=new ArrayList<>();
        solve(board,0,n,ans);
        return ans;
    }

    public static void solve(String[][]board, int row, int n,List<List<String>>ans){
        if(row==n){
            ans.add(construct(board));
            return ;
        }
        for(int i=0;i<n;i++){
            if(isSafe(board,row,i)){
                board[row][i]="Q";
                solve(board,row+1,n,ans);
                board[row][i]=".";
            }
        }

    }

    public static boolean isSafe(String[][] board , int r, int c){
        for(int i=0;i<r;i++){
            if(board[i][c].equals("Q")){
                return false;
            }
        }
        //Left diagonal
        int row = r;
        int col =c;
        while(r>=0 && c>=0){
            if(Objects.equals(board[r][c], "Q")){
                return false;
            }
            r--;
            c--;
        }
        r=row;
        c=col;
        //Right diagonal
        while(r>=0 && c<board.length){
            if(Objects.equals(board[r][c], "Q")){
                return false;
            }
            r--;
            c++;
        }
        return true;
    }

    public static List<String> construct(String board[][]){
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < board.length; j++) {
                sb.append(board[i][j]);
            }
            res.add(sb.toString());
        }
        return res;
    }
}
