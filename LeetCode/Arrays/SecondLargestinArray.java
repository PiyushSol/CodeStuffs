public class SecondLargestinArray {
    public static void main(String[] args) {
        int nums[]={1,2,4,7,7,5};
        System.out.println(secondLarget(nums));
    }

    public static int secondLarget(int nums[]){
        int largest = nums[0];
        int ans = Integer.MIN_VALUE;
        for(int i=1;i<nums.length;i++){
            if(nums[i]>largest){
                ans = largest;
                largest = nums[i];
            } else if (nums[i]<largest && ans<nums[i]) {
                ans=nums[i];
            }
        }
        return ans;
    }
}
