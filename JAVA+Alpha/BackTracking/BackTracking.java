package BackTracking;

public class BackTracking {
    public static void main(String[] args) {
       int suduko[][]= {
            {0,0,8,0,0,0,0,0,0},
            {4,9,0,1,5,7,0,0,2},
            {0,0,3,0,0,4,1,9,0},
            {1,8,5,0,6,0,0,2,0},
            {0,0,0,0,2,0,0,6,0},
            {9,6,0,4,0,5,3,0,0},
            {0,3,0,0,7,2,0,0,4},
            {0,4,9,0,3,0,0,5,7},
            {8,2,7,0,0,9,0,1,3}
        };
        System.out.println(sudukoSolver(suduko,0,0));

    }

    //Suduko Solver
    static boolean sudukoSolver(int [][] suduko , int row, int col){
        if(row == 9 ){
            printSuduko(suduko);
            return true;
        }



        int nextRow = row, nextCol = col+1;
        if(col+1==9){
           nextCol=0;
           nextRow=row+1;
        }
        if(suduko[row][col]!=0){
            return sudukoSolver(suduko,nextRow,nextCol);
        }
        for(int digit=1;digit<=9;digit++){
            if(isValid(suduko,row,col,digit)){
                suduko[row][col]=digit;
                if(sudukoSolver(suduko,nextRow,nextCol)){
                    return true;
                }
                suduko[row][col]=0;
            }
        }
        return false;
    }

    static boolean isValid(int [][] suduko, int row, int col , int digit){
        for(int i=0;i<=8;i++){
            if(suduko[i][col]==digit){
                return false;
            }
        }

        for(int j=0;j<=8;j++){
            if(suduko[row][j]==digit){
                return false;
            }
        }

        int sr = (row/3)*3;
        int sc = (col/3)*3;
        for(int i=sr;i<sr+3;i++){
            for(int j=sc; j<sc+3;j++){
                if(suduko[i][j]==digit){
                    return false;
                }
            }
        }

        return true;
    }

    static void printSuduko(int[][] suduko){
        for(int i=0;i<suduko.length;i++){
            for(int j=0;j< suduko.length;j++){
                System.out.print(suduko[i][j]+" ");
            }
            System.out.println();
        }
    }

    //Grid ways : Given source (0,0) count the total ways to reach (n-1,m-1) destination
    static int gridWays(int i, int j , int n, int m){
        if(i==n-1 && j==m-1){
            return 1;
        } else if (i==n ||j==m) {
            return 0;
        }
        int right = gridWays(i,j+1,n,m); //Right Choice
        int down = gridWays(i+1,j,n,m); //Down Choice
        return right+down;
    }

    //NQueens Problem

    static void nQueens(char[][] board, int row){
        if(row == board.length){
            display(board);
            return;
        }

        for(int i=0;i<board.length;i++){
            if(isSafe(board,row,i)) {
                board[row][i] = 'Q';
                nQueens(board, row + 1);
                board[row][i] = 'X'; //Backtrackking step
            }
        }
    }

    static boolean isSafe(char[][] board, int row , int col){
        //vertically check
        for(int i=row;i>=0;i--){
            if(board[i][col]=='Q'){
                return false;
            }
        }
        //left diagonal
        for(int i=row-1,j=col-1;i>=0&&j>=0;i--,j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }

        //right diagonal
        for(int i=row-1,j=col+1;i>=0 && j<board.length;i--,j++){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }

    static void display(char[][] board){
        System.out.println("-------------Chess Board-------------------");
        for(int i =0;i< board.length;i++){
            for(int j=0;j<board.length;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("-------------------------------------------");
    }


    /*
    ALl permutations of given string
     */

    static void permutations(String s, String ans){
        if(s.length()==0){
            System.out.println(ans);
            return;
        }
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
           String news= s.substring(0,i)+s.substring(i+1);
            permutations(news,ans+ch);
        }
        return;
    }

    //Subsets
    /*
    I/p = "abc"
    O/p = a,b,c,ab,ac,bc,abc
     */

    static void subsets(String s , String ans , int i){
        if(i==s.length()){
            System.out.println(ans);
            return;
        }
        subsets(s,ans+s.charAt(i),i+1);
        subsets(s,ans,i+1);
        return;
    }
}
