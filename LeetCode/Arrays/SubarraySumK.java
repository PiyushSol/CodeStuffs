import java.util.HashMap;
import java.util.Map;

public class SubarraySumK {
    public static void main(String[] args) {
        int nums[]= {1,1,1};
        int k=2;
        System.out.println(subarraySum(nums,k));
    }

    public static int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> mp = new HashMap<>();
        int cnt=0; int prefixSum=0;
        mp.put(0,1);
        for(int i=0;i< nums.length;i++){
            prefixSum+=nums[i];
            int remove = prefixSum-k;
            cnt += mp.getOrDefault(remove,0);
            mp.put(prefixSum,mp.getOrDefault(prefixSum,0)+1);
        }
        return cnt;
    }
}
