public class BookAllocation {
    public static void main(String[] args) {
        int nums[]={12, 34, 67, 90};
        System.out.println(findPages(nums,2));
    }

    public static int findPages(int[] nums, int m) {
        int mx = Integer.MIN_VALUE;
        int sm = 0;
        for(int i=0;i<nums.length;i++){
            mx =Math.max(mx,nums[i]);
            sm += nums[i];
        }
        int low = mx , high=sm;
        while(low<=high){
            int mid=(low)+(high-low)/2;
            if(countStudents(nums,mid)>m){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return low;
    }

    public static int countStudents(int[] nums , int pages){
        int cnt=1;
        int currentPages=0;
        for(int i=0;i< nums.length;i++){
            if(currentPages+nums[i]<=pages){
                currentPages += nums[i];
            }else{
                cnt++;
               currentPages = nums[i];
            }
        }
        return cnt;
    }
}
