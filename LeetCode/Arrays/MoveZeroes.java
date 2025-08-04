import java.util.Arrays;

public class MoveZeroes {
    public static void main(String[] args) {
      int nums[]={1,3,12};
      moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void moveZeroes(int[] nums) {
       int n = nums.length;
       int i=0, j=0;
       while(j<n){
           if(nums[j]!=0 && i!=j){
               int temp = nums[i];
               nums[i]=nums[j];
               nums[j]=temp;
               i++;
           }else if (nums[j] != 0) {
               i++;
           }
           j++;
       }
    }
}
