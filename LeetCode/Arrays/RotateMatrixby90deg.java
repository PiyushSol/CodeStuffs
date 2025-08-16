public class RotateMatrixby90deg {
    public static void main(String[] args) {
        int [][]matrix = {{1,2,3},{4,5,6},{7,8,9}};
        rotate(matrix);
        for(int []r :matrix){
            for(int el : r){
                System.out.print(el+" ");
            }
            System.out.println();
        }
    }

    public static void rotate(int[][] matrix) {
        int n= matrix.length;
        //First transpose the matrix
        for(int i=0;i<n-1;i++){
                for(int j=i+1;j<n;j++){
                    int temp = matrix[i][j];
                    matrix[i][j]=matrix[j][i];
                    matrix[j][i]=temp;
                }
            }
        //Now reverse the each row.
        for(int i=0;i<n;i++){
            reverseRow(matrix[i]);
        }

    }

    public static void reverseRow(int a[]){
        int s = 0 , e =a.length-1;
        while(s<e){
            int temp = a[s];
            a[s]=a[e];
            a[e]=temp;
            s++;
            e--;
        }
    }
}
