public class MajorityElement {
    public static void main(String[] args) {

    }

    public static int majorityElement(int[] nums) {
        int n=nums.length;
        int count=0;
        int el =nums[0];
        for(int i=0;i<n;i++){
            if(nums[i]==el){
                count++;
            }else if(count==0){
                count =1;
                el=nums[i];
            }else{
                count--;
            }
        }

        int cnt=0;
        for(int i=0;i<n;i++){
            if(el==nums[i]){
                cnt++;
            }
        }
        if(cnt > n/2){
            return el;
        }
        return -1;
    }
}
