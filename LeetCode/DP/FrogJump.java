public class FrogJump {

    //Memoization used
    public static int frogJump1(int[] heights) {
     int dp[] = new int[heights.length+1];
     return helper(heights.length-1,heights,dp);
    }

    public static int helper(int n , int heights[], int dp[]){
        if(n==0)return 0;
        if(dp[n]!=0)return dp[n];
        int left = helper(n-1,heights,dp)+Math.abs(heights[n-1]-heights[n]);
        int right = Integer.MAX_VALUE;
        if(n>1){
        right = helper(n-2,heights,dp)+Math.abs(heights[n-2]-heights[n]);
    }
        return dp[n] = Math.min(left,right);
    }

    //tabulation method
    public static int frogJump2(int[] heights) {
        int n=heights.length;
        int dp[] = new int[n];
        dp[0]=0;
        for(int i=1;i<n;i++){
            int fs = dp[i-1]+Math.abs(heights[i]-heights[i-1]);
            int ss =Integer.MAX_VALUE;
            if(i>1){
                ss=dp[i-2]+Math.abs(heights[i-2]-heights[i]);
            }
            dp[i] = Math.min(fs,ss);
        }
        return dp[n-1];
    }


    public static void main(String[] args) {
        int []h = {2,1,3,5,4};
        System.out.println(frogJump2(h));
    }
}
