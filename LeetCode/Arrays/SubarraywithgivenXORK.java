import java.util.HashMap;
import java.util.Map;

public class SubarraywithgivenXORK {
    public static void main(String[] args) {
        int nums[]={4,2,2,4,6};
        System.out.println(subarraysWithXorK(nums,6));
    }

    public static int subarraysWithXorK(int[] nums, int k) {
        int cnt=0;
        int n = nums.length;
        Map<Integer,Integer> mp = new HashMap<>();
        mp.put(0,1);
        int xor=0;
        for(int i=0;i<n;i++){
            xor = xor ^ nums[i];
            int x  = xor ^k;
            cnt += mp.getOrDefault(x,0);
            mp.put(xor, mp.getOrDefault(xor,0)+1);
        }
       return cnt;
    }
}
