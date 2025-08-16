import java.util.Arrays;

public class FirstandLastOccurence {
    public static void main(String[] args) {
        int nums[]={5,7,7,8,8,10};
        int target =8;
        System.out.println(Arrays.toString(searchRange(nums,target)));
    }

    public static int[] searchRange(int[] nums, int target) {
        int lb = lowerBound(nums,target);
        if(lb == nums.length|| nums[lb]!=target)return new int[]{-1,-1};
        return new int[]{lb,upperBound(nums,target)-1};
    }

    public static int lowerBound(int nums[] ,int x){
        int low=0 , high = nums.length-1;
        int ans = nums.length;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid]>=x){
                ans=mid;
                high =mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }

    public static int upperBound(int nums[],int x){
        int low=0 , high = nums.length-1;
        int ans = nums.length;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid]>x){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
}
