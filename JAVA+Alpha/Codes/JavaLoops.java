

public class JavaLoops{
    public static void main(String[] args) {
        // //while loop
        // int num=1;
        // while(num<=10){
        //     System.out.println((num));
        //     num++;
        // }

        // for Loop
        // for (int i = 0; i < 4; i++) {
        //     System.out.println("****");
        // }

        //do while loop
        // do{

        // }while(cond);
        // Scanner scan = new Scanner(System.in);
        // System.out.println("Enter a Number : ");
        // int n = scan.nextInt();

        // if(n==2){
        //     System.out.println("Number is Prime");
        // }

        // for(int div=2 ; div<=Math.sqrt(n) ; div++){
        //     if(n % div == 0){
        //         System.out.println("Not a Prime");
        //         break;
        //     }
        //     else{
        //         System.out.println("Number is Prime");
        //         break;
        //     }
        // }

        //Loop Pattern1 
        /*
        *
        **
        ***
        ****
      */

    //   for(int i=1 ;i<=5;i++){
    //     for(int j=1;j<=i;j++){
    //         System.out.print("*");
    //     }
    //     System.out.println("");
    //   }
    
    //-----------------------------------------------------------------------

     //Loop Pattern2 
        /*
        ****
        ***
        **
        *
      */

    //   for(int m=4; m>0 ; m--){
    //     for(int n=1 ;n<=m;n++){
    //         System.out.print("*");
    //     }
    //     System.out.println("");
    //   }

    //OR

    // for(int m=1 ;m<=4;m++){
    //     for(int n=1 ; n<=4-m+1;n++){
    //         System.out.print("*");
    //     }
    //     System.out.println("");
    // }

    //--------------------------------------------------
    //Pattern 3
    /*
    1
    12
    123
    1234
    */

    // for(int line=1;line<=4;line++){
    //     for(int num=1; num<=line;num++){
    //         System.out.print(num);
    //     }
    //     System.out.println("");
    // }

      //--------------------------------------------------
    //Pattern 4
    /*
  A
  BC
  DEF
  GHIJ
    */

    char ch='A';
    for(int i=1;i<=5;i++){
        for(int j=1;j<=i;j++){
            System.out.print(ch);
            ch++;
        }
        System.out.println("");
    }


    }
}