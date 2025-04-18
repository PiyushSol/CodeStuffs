package Codes.Recursion1;

public class Recursion1 {
    static int sum=0;
    public static void main(String[] args) {
//    print(10);
//      print1n(5);
//        System.out.println(factorial(5));
//        System.out.println(sum(100));
//        System.out.println(sumDigits(45));
//        System.out.println(prodDigits(505));
//        System.out.println(reverse(1824));
//         reverse(1824);
//        System.out.println(sum);
//        System.out.println(countZeroes(3900020));
    }

    //Count number of zeroes
    public static int countZeroes(int n){
        return helper(n ,0);
    }
    private static int helper(int n,int c){
        if (n==0){
            return c;
        }
        int rem= n%10;
        if (rem==0){
            return helper(n/10,c+1);
        }
        return helper(n/10,c);
    }


    //Reverse a number
    public static void reverse(int n){
        if (n==0){
            return ;
        }
        int rem=n%10;
        sum=sum*10+rem;
        reverse(n/10);
    }

    //product of digits
    public static int prodDigits(int n){
        if (n%10 == n){
            return n;
        }
        return (n%10)*prodDigits(n/10);
    }

     //sum of digits
    public static int sumDigits(int n){
        if (n<=0){
            return 0;
        }
        return (n%10)+sumDigits(n/10);
    }

    //sum of n numbers
    public static int sumD(int n){
        if (n<=1){
            return 1;
        }
        return n+sumD(n-1);
    }

     //factorial of a number
    public static int factorial(int n){
        if(n<=1){
            return 1;
        }
        return n*factorial(n-1);
    }

    //function to print 1-n
    public static void print1n(int n){
        if(n==1){
            System.out.print(n+" ");
            return;
        }
        print1n(n-1);
        System.out.print(n+" ");
    }

   //function to print n-1
    public static void printn1(int n){
        if (n==1){
            System.out.print(n+" ");
            return;
        }
        System.out.print(n+" ");
        printn1(n-1);
    }
}
