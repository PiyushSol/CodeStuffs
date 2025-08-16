import java.util.HashSet;
import java.util.Set;

public class LongestConsecutive {
    public static void main(String[] args) {
        int nums[]={100,4,200,1,3,2};
        System.out.println(longestConsecutive(nums));
    }

    public static int longestConsecutive(int[] nums) {
       int n=nums.length;
       int longest =1;
       if(n==0){
           return 0;
       }
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++){
            set.add(nums[i]);
        }

        for(int el : set){
            if(!set.contains(el-1)){
                int cnt =1;
                int x = el;
                while(set.contains(x+1)){
                    x = x+1;
                    cnt++;
                }
                longest=Math.max(longest,cnt);
            }
        }

       return longest;
    }
}
