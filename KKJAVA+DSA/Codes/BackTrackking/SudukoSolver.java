package Codes.BackTrackking;

public class SudukoSolver {
    public static void main(String[] args) {
            char [][] board = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };

            suduko(board,0,0);

    }

    static boolean suduko(char [][] board , int row , int col ){
        if(row == 9){
            display(board);
            System.out.println();
            return true;
        }
        int nextRow = row;
        int nextCol = col+1;
        if(nextCol == 9){
            nextRow = row+1;
            nextCol=0;
        }

        if(board[row][col]!='.'){
           return suduko(board,nextRow,nextCol);
        }

        //Place the digits
        for(char i='1';i<='9';i++){
            if(isSafe(board , row, col,i)){
                board[row][col] = i;
                if(suduko(board,nextRow,nextCol)){
                    return true;
                }
                board[row][col] = '.'; //Backtracking step
            }

        }
        return false;
    }

    private static boolean isSafe(char[][] board, int row, int col, char i) {
        //Checking horizontal
        for(int j=0;j<9;j++){
            if(board[row][j]== (char)i){
                return false;
            }
        }
        //Checking vertical
        for(int j=0;j<9;j++){
            if(board[j][col]== (char)i){
                return false;
            }
        }

        //Checking the grid as well
        int startRow = (row/3)*3;
        int startCol = (col/3)*3;
        for(int m = startRow;m<=startRow+2;m++){
            for(int n=startCol;n<=startCol+2;n++){
                if(board[m][n]== i){
                    return false;
                }
            }
        }

        return true;
    }

    private static void display(char[][] board) {
        for(char [] row : board){
            for( char ch : row){
                System.out.print(ch+" ");
            }
            System.out.println();
        }
    }
}
