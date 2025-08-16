public class SearchinRotatedArrayI {
    public static void main(String[] args) {
        int nums[]={4,5,6,7,0,1,2};
        System.out.println(search(nums,0));
    }

    public static int search(int[] nums, int target) {
        int l=0,h= nums.length-1;
        while(l<=h){
            int m = l+(h-l)/2;
            if(nums[m]==target){
                return m;
            }
            if(nums[l]<=nums[m]){
                if(nums[l]<=target && target<=nums[m]){
                    h= m-1;
                }
                else{
                    l=m+1;
                }
            }
            else{
                if(nums[m]<=target && target<=nums[h]){
                    l= m+1;
                }
                else{
                    h=m-1;
                }
            }

        }
        return -1;
    }
}
