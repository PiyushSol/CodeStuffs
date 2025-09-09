import java.util.Arrays;

public class HouseRobber2 {
    public static int rob(int[] nums) {
       int temp1 []= Arrays.copyOfRange(nums,1,nums.length);
       int temp2[] =Arrays.copyOfRange(nums,0,nums.length-1);
       if(nums.length ==1)return nums[0];
       return Math.max(nonAdjacent(temp1),nonAdjacent(temp2));
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

    public static void main(String[] args) {
        int nums[] = {1,2,3,1};
        System.out.println(rob(nums));
    }
}
