public class Search2DMatrix {
    public static void main(String[] args) {
//        int[][] mat={{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
          int[][]mat = {{5},{6}};
        System.out.println(searchMatrix(mat,6));

    }

    public static boolean searchMatrix(int[][] matrix, int target) {
       int row=0 , col = matrix[0].length-1;
       while(row< matrix.length && col>=0){
           if(matrix[row][col]==target){
               return true;
           } else if (matrix[row][col]<target) {
                row++;
           }
           else{
               col--;
           }
       }
       return false;
    }
}
