

public class Recursion{
    //Print Numbers from n to 1 (decreasing order)
   public static void  printNumbers(int n){
        if(n==0) return;
        System.out.println(n);
        printNumbers(n-1);
    }

     //Print Numbers from 1 to n (increasing order)
     public static void printInc(int n){
        if(n==0) return;
        printInc(n-1);
        System.out.print(n+" ");
     }

     //Print factorial of a number
     public static int factorial(int n){
        int fact =1;
        if(n==0) return 1;
        fact = n * factorial(n-1);
        return fact;
     }

     //Print sum of n natural numbers
     public static int printSum(int n){
        int sum=0;
        if(n==1){
            return 1;
        }
        sum = n + printSum(n-1);
        return sum;
     }

     //Print Nth fibonacci Number 
     public static int printNthFib(int n){
        if(n==0 || n==1){
            return n;
        }
       
        int term = printNthFib(n-1)+printNthFib(n-2);
        return term;
     }

     //Check if the given array is sorted or not
     public static boolean  isSorted(int arr[],int i){
        if(arr.length-1 == i){
            return true;
        }
        if(arr[i]>arr[i+1]){
            return false;
        }
        return isSorted(arr, i+1);
     }

     //WAF to find the first occurence of an element in an array
     public static int findFirstOccur(int arr[] , int key,int i){
        if(i == arr.length){
            return -1;
        }
        if(arr[i]==key){
            return i;
        }
        return findFirstOccur(arr,key, i+1);
     }

     //WAF to find the last occurence of an element in an array
     public static int findLastOccur(int arr[] , int key,int i){
        if(i == arr.length){
            return -1;
        }
       int isfound = findLastOccur(arr,key, i+1);
       if(isfound ==-1 && arr[i]==key){
        return i;
       }
       
       return isfound;
     }

     //Print x^n
     public static int printXn(int x, int n){
        if(n ==0){
            return 1;
        } 
        int xn1 = printXn(x, n-1);
        return x * xn1;
     }

     //Print x^n but in optimised format
     // x^n = x^n/2 * x^n/2 when n is even
     // x^n = x * x^n/2 * x^n/2 when n is odd
     public static int power(int x , int n){
        if(n==0){
            return 1;
        }
       int halfPower = power(x,n/2);
       int halfPowerSquared = halfPower * halfPower;
       if(n % 2 !=0){
        halfPowerSquared = x * halfPowerSquared;
       }
       return halfPowerSquared;
     }

     //Tiling Problem
    //  Given a 2 X n board and tiles of sizes 2X1 , count the number of ways to tile
    //  the the given board using the 2X1 tiles. (A tile can either be placed horizontally or vertically)
    public static int tilingProblem(int n){
        //base case
        if(n==0 || n==1){
            return 1;
        }

        //kaam jo humko karna means choice lena ki vertical tiling ya horizontal tiling
        //vertical choice
        int verticalTiles = tilingProblem(n-1);

        //horizontal choice
        int horizontalTiles = tilingProblem(n-2);

        //total ways
        int totalWays = horizontalTiles+verticalTiles;
        return totalWays;
    } 

    //remove duplicates in a string with only letters allowed are b/w a-z
     public static void removeDuplicates(String str , int idx, StringBuilder newStr , boolean  map[]){
        if(idx == str.length()){
            System.out.println(newStr);
            return;
        }

        char currChar= str.charAt(idx);
        if(map[currChar-'a'] == true){
            //then the character is duplicates
          removeDuplicates(str, idx+1, newStr, map);  
        }else{
            map[currChar-'a']=true;
         removeDuplicates(str, idx+1, newStr.append(currChar), map);
        }
     }

      //Pairing problem - Pairing 'n' friends
       public static int pairingFriends(int n){
        if(n==1 || n==2){
            return n;
        }

        //choice
        //single 
        int fnm1 = pairingFriends(n-1);

        //pair
        int fnm2 = pairingFriends(n-2);
        int pairs = (n-1)*fnm2;

        //total ways
        int totalWays=pairs+fnm1;
        return totalWays;

        // return pairingFriends(n-1)+(n-1)*pairingFriends(n-2); 

       }

       //Print all binary strings of size N without consectuvie ones
       public static void printBinStrings(int n , int lastPlace , String str){

        //basecase
        if(n==0){
            System.out.println(str);
            return;
        }

        printBinStrings(n-1,0,str+"0");
        if(lastPlace == 0){
            printBinStrings(n-1,1,str+"1");
        }
       }

    public static void main(String[] args) {
        // printNumbers(10);
        // printInc(20);
        // System.out.println(factorial(50)); 
        // System.out.println("The Sum is "+printSum(40));
        // System.out.println(printNthFib(2)); 
        // int []arr ={1,2,3};
        // System.out.println(isSorted(arr, 0));
        //  int arr[]={5,5,5,5};
        //  System.out.println(findFirstOccur(arr, 1, 0));
        // System.out.println(findLastOccur(arr, 5, 0));  
        // System.out.println(printXn(2,5));
    //    System.out.println(tilingProblem(4));
    // String str ="appnnacollege";
    // removeDuplicates(str,0,new StringBuilder(""), new boolean[26]);
        // System.out.println(pairingFriends(5));
        printBinStrings(3,0,"");
    
    }
}