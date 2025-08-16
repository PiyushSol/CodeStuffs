public class SmallestDivisor {
    public static void main(String[] args) {
        int nums[]={44,22,33,11,1};
        System.out.println(smallestDivisor(nums,5));
    }

    public static int smallestDivisor(int[] nums, int threshold) {
        int mx = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            mx = Math.max(mx,nums[i]);
        }

        int low = 1 , high=mx;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(getSum(nums,mid)<=threshold){
                high =mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }

    public  static int getSum(int a[], int divisor){
        int sum=0;
        for(int i=0;i<a.length;i++){
            sum += (int)Math.ceil((double) a[i]/(double) divisor);
        }
        return sum;
    }
}
