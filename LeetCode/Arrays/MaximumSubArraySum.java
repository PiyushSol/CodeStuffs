public class MaximumSubArraySum {
    public static void main(String[] args) {

    }

    public static int maxSum(int nums[]){
        int sum=0;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(sum<0){
                sum=0;
            }
            max = Math.max(max,sum);
        }
        return max;
    }
}
