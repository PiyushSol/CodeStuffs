public class LowerBound {
    public static void main(String[] args) {
    int nums[]={3,5,8,15,19};
        System.out.println(lowerBound(nums,3));
    }

    public static int lowerBound(int nums[] ,int x){
        int low=0 , high = nums.length-1;
        while(low<high){
            int mid = low+(high-low)/2;
            if(nums[mid]>=x){
                high =mid;
            }
            else{
                low=mid+1;
            }
        }
        return high;
    }
}
