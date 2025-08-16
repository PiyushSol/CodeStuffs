public class MaxProductSubarray {
    public static void main(String[] args) {
        int nums[]={-1,2};
        System.out.println(maxProduct(nums));
    }

    public static int maxProduct(int[] nums) {
        int n= nums.length;
        int mx = Integer.MIN_VALUE;
        int pre = 1, suff =1;
        for(int i=0;i<n;i++){
            if(pre==0)pre=1;
            if(suff==0)suff=1;
            pre *= nums[i];
            suff*= nums[n-i-1];
            mx = Math.max(mx, Math.max(pre,suff));
        }
        return mx;
    }
}
