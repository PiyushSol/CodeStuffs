public class SetZeroes {
    public static void main(String[] args) {
        int[][] matrix ={{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        setZeroes(matrix);
        for(int []r :matrix){
            for(int el:r){
                System.out.print(el+" ");
            }
            System.out.println();
        }
    }

    public static void setZeroes(int[][] matrix) {
        //Column zeores are tracked by first row m[0][..] and Row zeroes are tracked by first col m[..][0]
        int m= matrix.length;
        int n= matrix[0].length;
       int col0=1;
       for(int i=0;i<m;i++){
           for(int j=0;j<n;j++){
               if(matrix[i][j]==0){
                   matrix[i][0]=0;
                   if(j!=0){
                       matrix[0][j]=0;
                   }else{
                       col0=0;
                   }
               }
           }
       }

       for(int i=1;i<m;i++){
           for(int j=1;j<n;j++){
               if(matrix[i][0]==0||matrix[0][j]==0){
                   matrix[i][j]=0;
               }
           }
       }

       if(matrix[0][0]==0){
           for(int j=0;j<n;j++){
               matrix[0][j]=0;
           }
       }
       if(col0==0){
           for(int i=0;i<m;i++){
               matrix[i][0]=0;
           }
       }

    }
}
