public class WordSearch {
    public static void main(String[] args) {
        char board[][] = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(exist(board,"SEE"));
    }

    public static boolean exist(char board[][] , String word){
        int m = board.length;
        int n= board[0].length;

        boolean visited[][] =new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(word.charAt(0) == board[i][j]){
                    boolean result =  find(board , i,j,0,visited,word);
                    if(result){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean find(char board[][],int i,int j,int idx ,boolean visited[][],String word){
        if(idx == word.length()){
          return true;
        }

        if(i<0||j<0||i>= board.length||j>=board[0].length||visited[i][j]||board[i][j]!=word.charAt(idx)){
            return false;
        }

        visited[i][j]=true;
        if(find(board,i+1,j,idx+1,visited,word)||find(board,i-1,j,idx+1,visited,word)||find(board,i,j+1,idx+1,visited,word)||find(board,i,j-1,idx+1,visited,word)){
            return true;
        }

        visited[i][j]=false;
        return false;
    }
}
