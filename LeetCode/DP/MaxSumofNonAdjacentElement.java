public class MaxSumofNonAdjacentElement {
    public static int nonAdjacent1(int[] nums) {
        //This is normal Dp solution
        int dp[]= new int[nums.length];
        return helper(nums.length-1,dp,nums);
    }

    public static int nonAdjacent2(int[] nums){
        //This is DP tabulation solution
        int[]dp = new int[nums.length];
        dp[0]=nums[0];
        for(int i=1;i< nums.length;i++){
            int take = nums[i];
            if(i>1)take+=dp[i-2];
            int notake = 0+dp[i-1];
            dp[i] = Math.max(take,notake);
        }
        return dp[nums.length-1];
    }

    public static int nonAdjacent(int []nums){
        //Best Solution space optimised
        int prev =nums[0];
        int prev2 = 0;
        for(int i=1;i< nums.length;i++){
            int take = nums[i];
            if(i>1)take+=prev2;
            int notake = prev+0;
            int curri = Math.max(take,notake);
            prev2 =prev;
            prev = curri;
        }
        return prev;
    }

    public static int helper(int idx , int []dp , int[]n){
        if(idx == 0)return n[0];
        if(idx<0)return 0;
        if(dp[idx]!=0)return dp[idx];
        int pick = n[idx]+helper(idx-2,dp,n);
        int notpick = 0 + helper(idx-1,dp,n);
        return dp[idx]=Math.max(pick,notpick);
    }

    public static void main(String[] args) {
        int [] nums = {2,1,4,9};
        System.out.println(nonAdjacent(nums));
    }
}
