public class NthRootOfInteger {
    public static void main(String[] args) {
        System.out.println(NthRoot(4,81));
    }

    public static int NthRoot(int N, int M) {
        int low=1, high = M;
        while(low<=high){
            int mid = low +(high-low)/2;
            if(getPower(mid,N)==M){
                return mid;
            }
            else if(getPower(mid,N)<M){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return  -1;

    }

    public static int getPower(int n , int p){
        if(p ==0){
            return 1;
        }
        int halfPower = getPower(n,p/2);
        int res=0;
        if (p%2==1){
            res = n * halfPower*halfPower;
        }
        else {
            res = halfPower * halfPower;
        }
        return res;
    }
}
