public class PerfectSquares {
    public static void main(String[] args) {
        System.out.println(count(12));
        System.out.println(count(13));
        System.out.println(count(16));
    }
    static int arr[] = new int[1001];
    public static int count(int n){

        if(n==0){
            return 0;
        }

        if(arr[n]!= 0){
         return arr[n];
        }
        int ans = Integer.MAX_VALUE;
        for(int i=1;i*i<=n;i++){
            int temp = 1+count(n- (i*i));
            ans = Math.min(ans,temp);
        }
        return arr[n]=ans;
    }
}
