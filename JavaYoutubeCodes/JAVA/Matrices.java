

public class Matrices{
    
    public static boolean search(int matrix[][] , int key){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(matrix[i][j]==key){
                    System.out.println("Found at cell : ("+ i +","+j+")" );
                    return true;
                }
            }
        }
        System.out.println("Key not found!");
        return false;
    }

    //Spiral Matrix question of MAANG
    public static void spiralMatrix(int arr[][]){
        int startRow=0 , startCol=0 , endRow = arr.length-1 , endCol =arr.length-1;
        while (startRow<=endRow && startCol<=endCol) {
            //top
            for(int j=startCol;j<=endCol;j++){
                System.out.print(arr[startRow][j]+" ");
            }
            
            //right
            for(int i=startRow+1;i<=endRow;i++ ){
                System.out.print(arr[i][endCol]+" ");
            }

            //bottom
            for(int j=endCol-1 ; j>=startCol;j--){
                if(startRow == endRow){
                    break;
                }
                System.out.print(arr[endRow][j]+" ");
            }

            //left
            for(int i=endRow-1;i>=startRow+1;i--){
                if(startCol == endCol){
                    break;
                }
                System.out.print(arr[i][startCol]+" ");
            }
            startRow++ ;
            startCol++ ;
            endCol--;
            endRow--;
        }
        System.out.println();
    }

    //Diagonal Matrix Sum - Amazon , Google , Samsung
    public static int diagonalSum(int matrix[][]){
        int sum=0;
        // for(int i=0;i< matrix.length;i++){
        //     for(int j=0 ; j< matrix[0].length;j++){
        //         if(i == j){
        //             sum+=matrix[i][j];
        //         }
        //         else
        //         if(i+j == matrix.length-1){
        //             sum+=matrix[i][j];
        //         }
        //     }
             
        // }
//The above code is not optimised version as it runs on O{n2} complexity

for(int i=0 ; i< matrix.length ;i++){
    //pd
    sum+=matrix[i][i];

    //sd
    if(i!=matrix.length-1-i)
        sum += matrix[i][matrix.length-i-1];
}

        return sum;
    }

    //Search in row wise and col wise sorted matrix
    public static boolean staircaseSearch(int matrix[][], int key)
{
    int row =0 , col = matrix[0].length-1;
    while(row < matrix.length && col >=0){
        if(matrix[row][col]== key){
            System.out.println("Found key at ("+row+","+col+")");
            return true;
        }
        else if (key<matrix[row][col]){
            col--;
        }
        else{
            row++;
        }

    }
    System.out.println("Key Not found");
    return false;
}
    public static void main(String[] args) {
        // int matrix[][] = new int[3][3];
        // Scanner sc= new Scanner(System.in);
        // for(int i=0;i<3;i++){
        //     for(int j=0;j<3;j++){
        //         matrix[i][j]=sc.nextInt();
        //     }
        // }
        // int matrix[][]={
        //     {1,2,3,4},
        //     {5,6,7,8},
        //     {9,10,11,12},
        //     {13,14,15,16}
        // };

        // //output
        // for(int i=0;i<3;i++){
        //     for(int j=0;j<3;j++){
        //         System.out.print(matrix[i][j]+" ");
        //     }
        //     System.out.println("");
        // }

        // spiralMatrix(matrix);
        // search(matrix, 10);
        //  System.out.println(diagonalSum(matrix));
        int matrix[][]={
            {10,20,30,40},
            {15,25,35,45},
            {27,29,37,48},
            {32,33,39,50}
        };
        int key=333;
        staircaseSearch(matrix, key);
    }
}