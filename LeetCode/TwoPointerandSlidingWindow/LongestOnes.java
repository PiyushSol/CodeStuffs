public class LongestOnes {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,0,0,0,1,1,1,1,0};
        int k=2;
        System.out.println(longestOnes(nums,k));
    }

    public static int longestOnes(int[] nums, int k) {
        int l=0,r=0;
        int n = nums.length;
        int zeroes= 0;
        int maxlen=0;
        while(r<n){
            if(nums[r]==0) {
                zeroes++;
            }
            if(zeroes>k){
                if(nums[l]==0){
                    zeroes--;
                }
                l++;
            }
            maxlen = Math.max(maxlen,r-l+1);
            r++;
        }
        return maxlen;
    }

}
