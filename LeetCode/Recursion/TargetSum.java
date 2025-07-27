public class TargetSum {
    public static void main(String[] args) {
        int nums[]=new int[]{1};
        System.out.println(findTargetSumWays(nums,1));
    }

    public static int findTargetSumWays(int[] nums, int target){
        return totalWays(nums,0,0,target);
    }

    public static int totalWays(int nums[],int sum ,int idx , int target){
        if(idx==nums.length){
            return sum == target ? 1 : 0;
        }

        int plusWays =totalWays(nums,sum+nums[idx],idx+1,target);
        int minusways =totalWays(nums,sum-nums[idx],idx+1,target);
        return plusWays+minusways;
    }
}
