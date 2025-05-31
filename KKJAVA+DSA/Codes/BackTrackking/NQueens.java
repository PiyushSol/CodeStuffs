package Codes.BackTrackking;

public class NQueens {
    public static void main(String[] args) {
        int n=6;
        boolean board[][]= new boolean[n][n];
        System.out.println(queens(board,0));
    }

    //Nqueen problem solution
    static int queens(boolean [][] board, int r ){
        //True on the board means a queen is placed.
        if(r == board.length){
            display(board);
            System.out.println();
            return 1;
        }
         int count=0;
        ///Placing the queen and checking for every row and column
        for(int col=0;col< board.length;col++){
            //Place the queen if it is safe to do it
            if(isSafe(board,r,col)){
                board[r][col]=true;
                count += queens(board,r+1);
                board[r][col]=false;
            }
        }
    return count;
    }

    private static boolean isSafe(boolean[][] board, int r, int col) {
        for(int i=0;i<r;i++){
            if(board[i][col]){
                return false;
            }
        }

        //diognal left
        int maxLeft = Math.min(r,col);
        for(int i=1;i<=maxLeft;i++){
            if(board[r-i][col-i]){
                return false;
            }
        }

        //diognal right
        int maxRight = Math.min(r,board.length-col-1);
        for(int i=1;i<=maxRight;i++){
            if(board[r-i][col+i]){
                return false;
            }
        }
        return true;
    }

    private static void display(boolean[][] board) {
        for(boolean[] row : board){
            for(boolean element : row){
                if(element){
                    System.out.print("Q ");
                }
                else{
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }
}
