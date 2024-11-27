public class Patterns{

    public static void hollow_rectangle(int tot_rows , int tot_cols){
         //Pattern 1
        /*
        *****
        *   *
        *   *
        *****
        */

        for(int i=1 ; i<=tot_rows;i++){
            for(int j=1; j<=tot_cols;j++){
                //cell = (i,j)
                if(i==1 || i==tot_rows || j==1 || j==tot_cols){
                    //boundary conditions
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void half_pyramid(int n){
        //Pattern 2
        /*
        *
       **
      ***
     **** 
     */
    //outer loop
    for(int i=1;i<=n;i++){
        //inner loop to print spaces
        for(int j=1;j<=n-i;j++){
            System.out.print(" ");
        }
        //inner loop to print stars
        for(int k=1;k<=i;k++){
            System.out.print("*");
        }
        System.out.println("");
    }
    }

    public static void inverted_halfpyramid_withnos(int n){
        //Pattern 3
        /*
        12345
        1234
        123
        12
        1 */
        for(int i=1 ;i<=n;i++){
            for(int j=1; j<=n-i+1;j++){
                System.out.print(j+" ");
            }
            System.out.println("");
        }
    }
    
    public static void floydsTriangle(int n){
    //Pattern4
    /*
    1
    23
    456
    78910
    1112131415
    */
    int counter=1;
    for(int i=1;i<=n;i++){
        for(int j=1;j<=i;j++){
            System.out.print(counter+" ");   
            counter++;  
        }
       
        System.out.println("");
    }
   } 
   
    public static void zero_one_triangle(int n){
        //Pattern5
        /*
        1
        01
        101
        0101
        10101
        */
         for(int i=1 ;i<=n ;i++){
            for(int j=1; j<=i ;j++){
                if((i+j) % 2 == 0){
                    System.out.print(" 1 ");
                }
                else{
                    System.out.print(" 0 ");
                }
            }
            System.out.println("");
         }
    } 
   
    public static void butterfly_Pattern(int n){
        //Pattern 6
        /* 

        *      *
        **    **
        ***  ***
        ********
        ********
        ***  ***
        **    **
        *      *
        
        */
        //1st half
        //outer loop to print first stars
        for(int i=1;i<=n;i++){
            //stars - i
            for(int j=1; j<=i;j++){
                System.out.print("*");
            }

            //spaces - 2*(n-i)
            for(int k=1 ;k<=2*(n-i); k++){
                System.out.print(" ");
            }

            //stars - i
            for(int j=1 ; j<=i;j++){
                System.out.print("*");
            }
            System.out.println("");
        }

        //2nd Half
        for(int i=n; i>=1 ; i--){
              //stars - i
              for(int j=1; j<=i;j++){
                System.out.print("*");
            }

            //spaces - 2*(n-i)
            for(int k=1 ;k<=2*(n-i); k++){
                System.out.print(" ");
            }

            //stars - i
            for(int j=1 ; j<=i;j++){
                System.out.print("*");
            }
            System.out.println("");
        }
    }
    
    public static void solidRhombus(int n){
        //Pattern 7
        /*
        *****
       *****
      *****
     *****
    *****
    */

    for(int i=1 ; i<=n;i++){
        //Spaces
        for(int j=1; j<=n-i;j++){
            System.out.print(" ");
        }

        //Stars
        for(int k=1;k<=n;k++){
            System.out.print("*");
        }
        System.out.println("");
    }

    }
   
    public static void hollowRhombus(int n){
        //Pattern 8
        /*
        *****
       *   *
      *   *
     *   *
    *****     
        */
        //spaces
        for(int i=1 ; i<=n;i++){
            for(int j=1; j<=n-i;j++){
                System.out.print(" ");
            }
            //hollow rectangle code
            for(int j=1;j<=n;j++){
                if(i==1 || i==n ||j==1 ||j==n){
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
    
    public static void diamondPattern(int n){
        //Pattern 9
        /*
        *
       ***
      *****
     *******
     *******
      *****
       ***
        *
        */
        
         //1st Half
        for(int i=1;i<=n;i++){
            //Spaces
            for(int j=1;j<=n-i;j++){
                System.out.print(" ");
            }
            //Stars
            for(int k=1;k<=(2*i-1);k++){
                System.out.print("*");
            }
            
            System.out.println();
        }

        //2nd Half
        for(int i=n;i>=1;i--){
             //Spaces
             for(int j=1;j<=n-i;j++){
                System.out.print(" ");
            }
            //Stars
            for(int k=1;k<=(2*i-1);k++){
                System.out.print("*");
            }
           
            System.out.println();
        }
    }
    public static void main(String args[]){
       diamondPattern(4);
    } 
}