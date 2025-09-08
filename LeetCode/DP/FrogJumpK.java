public class FrogJumpK {
    public static int frogJump(int[] heights, int k) {
        int n=heights.length;
        int dp []=  new int[n];
        dp[0] = 0;
        for(int i=1;i<n;i++){
            int minSteps = Integer.MAX_VALUE;
            for(int j=1;j<=k;j++){
                if(i-j>=0){
                    int jmp = dp[i-j]+Math.abs(heights[i-j]-heights[i]);
                    minSteps = Math.min(minSteps,jmp);
                }
                else break;
            }
            dp[i]=minSteps;
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        int []h = {15, 4, 1, 14, 15};
        System.out.println(frogJump(h,3));
    }
}
