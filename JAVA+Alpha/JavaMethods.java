public class JavaMethods{

    public static void printHelloWorld(){
        System.out.println("Hello World!");
    } 
     
    public static int calculateSum(int a , int b){
       return a+b;
    }

    //Code to swap to Numbers
public static void swap(int a , int b){
    int temp =a;
    a=b;
    b=temp;
    System.out.println("a = "+ a);
    System.out.println("b = "+ b);
}

//Code to Multiply two Numbers
public static int multiply(int num1 , int num2){
    return num1*num2;
}

//Code to calcualte factorial of a number
public static int factorial(int num){
    int result=1;
    for(int i=1 ; i<=num;i++){
        result *=i;
    }
    return result;
}

//Code to calculate the binomial coefficient of any number
public  static int binomialCoefficient(int n , int r){
    int n_fact = factorial(n);
    int r_fact = factorial(r);
    int denom = factorial(n-r);
    int result = (n_fact) / (r_fact * denom);
    return result;
}

//Code to check if a number is Prime or not
public static boolean isPrime(int n){
    if(n==2){
        return true;
    }

    for(int i=2 ; i<=Math.sqrt(n);i++){
        if(n% i ==0){
            return false;
        }
    }
    return true;
}

//Code to print prime numbers in a range
public static void PrimesinRange(int n){
    for(int i=2; i<=n; i++){
        if(isPrime(i)){
            System.out.print(i+" ");
        }
    }
    System.out.println();
} 

//Code to convert numbers from Binary to Decimal
public static void binToDec(int binNum){
    int pow=0;
    int num = binNum;
    int decNum =0 ;
    while(binNum>0){
        int lastDigit = binNum % 10;
        decNum = decNum + (lastDigit * (int)Math.pow(2,pow));
        pow++;
        binNum = binNum /10;
    }
    System.out.println("Decimal of "+ num + " = "+ decNum);
}

//Code to convert numbers from Decimal to Binary
public static void decToBin(int decNum){
    int mynum = decNum;
    int pow =0;
    int binNum=0;
    while(decNum>0){
        int rem = decNum % 2;
        binNum = binNum + (rem * (int)Math.pow(10,pow));
        pow++;
        decNum = decNum /2;
    }
    System.out.println("Binary of "+ mynum + " = "+ binNum);
}

    public static void main(String[] args) {

} 
}