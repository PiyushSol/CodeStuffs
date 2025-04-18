package BitManipulations;

public class BitMan {
    public static void main(String[] args) {
//        System.out.println(isEvenOdd(68));
//       int arr [] = {2,3,4,1,2,1,3,6,4};
//        System.out.println(checkTimes(arr));
//        System.out.println(getMagicNumber(5));
//        System.out.println(getDigits(10 ,2));
//        System.out.println(getNthRowSum(3));
//        System.out.println(
////                checkPower(11)
//
//        );
//        System.out.println(power(3,6));
//        System.out.println(setBits(7));
    }

    //Number of set bits in 'n'
    public static int setBits(int n){
        int count=0;
        while(n>0){
            if((n&1) == 1){
                count++;
            }
            n=n>>1;
        }
        return count;
    }

    //Calculate a^b
    public static int power(int a , int b){
        int base=a;
        int ans=1;
        while(b>0){
            if((b&1) == 1){
              ans*=base;
            }
            base*=base;
            b=b>>1;
        }

        return ans;
    }

    //Check if the number is power of 2 or not
    public static boolean checkPower(int n){
        if (n==0) return false;
        return (n & (n-1))==0;
    }

    //pascals Triangle . Get the sum of the nth row
    public static int getNthRowSum(int n){
        return (1<<(n-1));
    }

    //Check number is even or odd.
     public static boolean  isEvenOdd(int n){
        return (n&1) == 1;
     }

     //Given array see which number comes only one times
    public static int checkTimes(int []arr){
         int unique=0;
         for(int n:arr){
             unique^=n;
         }
         return unique;
    }

    //Magic Number
    public static int getMagicNumber(int n){
        int ans =0;
        int base =5;
        while(n>0){
            int last = n &1;
            n= n>>1;
            ans+=last*base;
            base = base *5;
        }
        return ans;
    }

    //Number of Digits in number n of base b
    public static int getDigits(int n , int b){
        return (int)(Math.log(n)/Math.log(b))+1;
    }
}
