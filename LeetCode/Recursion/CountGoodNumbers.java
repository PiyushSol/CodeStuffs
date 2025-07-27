public class CountGoodNumbers {
    public static void main(String[] args) {
        System.out.println(goodNum(4));
    }

    public static  int goodNum(long n){
       long evenWays = findPower(5,(n+1)/2);
       long oddWays = findPower(4,n/2);
       return (int) ((evenWays*oddWays)%1000000007);
    }

    public static long findPower(long a , long b){
        if(b==0){
            return 1;
        }
        long half = findPower(a,b/2);
        long result =  ((half*half)% 1000000007);
        if(b%2==1){
            result =  ((a*result) % 1000000007);
        }
        return result;
    }
}
