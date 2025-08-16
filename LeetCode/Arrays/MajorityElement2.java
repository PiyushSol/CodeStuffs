import java.util.ArrayList;
import java.util.List;

public class MajorityElement2 {
    public static void main(String[] args) {
        int[]nums = {3,2,3};
        System.out.println(majorityElement(nums));
    }

    public static List<Integer> majorityElement(int[] nums) {
        List<Integer>ans =new ArrayList<>();
        int el1 = Integer.MIN_VALUE, el2=Integer.MIN_VALUE;
        int cnt1 =0 , cnt2=0;
        for(int i=0;i< nums.length;i++){
            if(cnt1==0 && el2!=nums[i]){
                cnt1=1;
                el1=nums[i];
            } else if (cnt2==0 && el1!=nums[i]) {
                cnt2=1;
                el2=nums[i];
            } else if (el1==nums[i]) {
                cnt1++;
            } else if (el2==nums[i]) {
                cnt2++;
            }
            else {
                cnt1--;
                cnt2--;
            }
        }

        cnt1=0 ; cnt2=0;
        for(int i=0;i< nums.length;i++){
            if(el1==nums[i])cnt1++;
            if(el2==nums[i])cnt2++;
        }
        int min =( (int)Math.floor(nums.length)/3)+1;
    if(cnt1>=min)ans.add(el1);
    if(cnt2>=min)ans.add(el2);
    return ans;
    }
}
