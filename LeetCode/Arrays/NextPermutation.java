import java.util.Arrays;

public class NextPermutation {
    public static void main(String[] args) {
        int[] nums={3,2,1};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void nextPermutation(int[] nums){
        int idx = -1;
        int n=nums.length;
        for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                idx =i;
                break;
            }
        }
        if(idx ==-1){
            reverse(nums,0,n-1);
            return;
        }

        for(int i=n-1;i>=idx;i--){
            if(nums[i]>nums[idx]){
                int temp=nums[idx];
                nums[idx]=nums[i];
                nums[i]=temp;
                break;
            }
        }
        reverse(nums,idx+1,n-1);
        return;
    }

    public static void reverse(int []nums,int s ,int e){
        while(s<e){
            int temp=nums[s];
            nums[s]=nums[e];
            nums[e]=temp;
            s++;
            e--;
        }

    }
}
