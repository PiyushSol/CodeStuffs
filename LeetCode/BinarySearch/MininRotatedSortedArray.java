public class MininRotatedSortedArray {
    public static void main(String[] args) {
        int nums[] = {3,4,5,1,2};
        System.out.println(findMin(nums));
    }

    public static int findMin(int[] nums) {
        int low =0 , high = nums.length-1, min = Integer.MAX_VALUE;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[low]<=nums[high]){
                min = Math.min(min ,nums[low]);
                break;
            }
            if(nums[low]<=nums[mid]){
                min = Math.min(min , nums[low]);
                low = mid+1;
            }else{
                high=mid-1;
                min = Math.min(min , nums[mid]);
            }
        }
        return min;
    }
}
