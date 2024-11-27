
public class BitManipulation {

    public static void checkEvenOdd(int n) {
        int bitMask = 1;
        if ((n & bitMask) == 0) {
            System.out.println("Even Number");
        } else {
            System.out.println("Odd Number");
        }
    }

    public static int getIthBit(int n, int i) {
        int bitMask = 1 << i;
        if ((n & bitMask) == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    public static int setIthBit(int n, int i) {
        int bitMask = 1 << i;
        return n | bitMask;
    }

    public static int clearIthBit(int n, int i) {
        int bitMask = ~(1 << i);
        return n & bitMask;
    }

    public static int updateIthBit(int n, int i, int newBit) {
        if (newBit == 0) {
            return clearIthBit(n, i);
        } else {
            return setIthBit(n, i);
        }

        //Another approach  
        // n = clearIthBit(n, i);
        // int BitMask = newBit<<i;
        // return n | BitMask;
    }

    public static int clearIBits(int n, int i) {
        int bitMask = (-1) << i;
        // or we can use (~0)<<i
        return n & bitMask;
    }

    public static int clearIBitsinRange(int n, int i, int j) {
        int a = (~0 << (j + 1));
        int b = (1 << i) - 1;
        int bitMask = a | b;
        return n & bitMask;
    }

    //check if number is power of 2
    public static boolean isPowerofTwo(int n){
        return (n&(n-1)) ==0;
    }

    //Count no of set bits in a number
    public static int countSetBits(int n){
        int count=0;
        while(n>0){
            if((n & 1) !=0){
                count++;
            }
            n=n>>1;
        }
        return count;
    }

    //fast exponentiation
    public static int fastExpo(int a, int n){
        int ans=1;

        while(n>0){
            if((n&1)!=0){
                ans *=a;
            }
            a=a*a;
            n=n>>1;
        }

        return ans;
    }


    public static void main(String[] args) {
        // System.out.println((5 & 6));
        // System.out.println((5 | 6));
        // System.out.println((5 ^ 6));
        // System.out.println((~5));
        // System.out.println((~0));
        // System.out.println(5<<2);
        // System.out.println(5>>2);
        // checkEvenOdd(3);
        // checkEvenOdd(11);
        // checkEvenOdd(14);

        // System.out.println(getIthBit(10, 3));
        // System.out.println(setIthBit(10, 2));
        // System.out.println(clearIthBit(10,1));
        // System.out.println(clearIBits(15,2));
        //    System.out.println(clearIBitsinRange(10, 2, 4));
        // System.out.println(isPowerofTwo(9));

        // System.out.println(countSetBits(16));
System.out.println(fastExpo(3,5));
    }
}
