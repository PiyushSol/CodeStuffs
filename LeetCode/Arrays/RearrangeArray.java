import java.util.Arrays;

public class RearrangeArray {
    public static void main(String[] args) {
        int nums[]={3,1,-2,-5,2,-4};
        System.out.println(Arrays.toString(rearrangeArray(nums)));
    }
    public static int[] rearrangeArray(int[] nums) {
        int n=nums.length;
        int ans[]=new int[n];
        int pos=0,neg=1;
        for(int i=0;i<n;i++){
            if(nums[i]<0){
                ans[neg]=nums[i];
                neg+=2;
            }
            else{
                ans[pos]=nums[i];
                pos+=2;
            }
        }
        return ans;
    }

    public static int[] BruterearrangeArray(int[] nums) {
        int pos []= new int[nums.length/2];
        int neg[]= new int[nums.length/2];

        int m=0,n=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                pos[m]=nums[i];
                m++;
            }
            else{
                neg[n]=nums[i];
                n++;
            }
        }

        for(int i=0;i<nums.length/2;i++){
           nums[2*i]=pos[i];
           nums[2*i+1]=neg[i];
        }
        return nums;
    }
}
