public class MinNonZeroProduct {
    public static void main(String[] args) {
        System.out.println(minNonZeroProduct(3));
    }

    public static int  minNonZeroProduct(int p) {
        long N = (long)Math.pow(10,9)+7;
        long max = (long) Math.pow(2,p)-1;
        long power = pow(max-1,(max-1)/2);
        power = ((power%N)* (max%N))%N;
        return (int) power;
    }

    public static long pow(long x  ,long n){
        if(n==0)return 1;
        long N = (long)Math.pow(10,9)+7;
        long temp  =pow(x,n/2);
        temp = temp%N;
        if(n%2==0){
            return (temp*temp)%N;
        }else{
            return (((temp*temp)%N)*(x%N))%N;
        }
    }
}
