import java.util.*;

public class SlidingWindow {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n == 0 || k == 0) return new int[0];
        int ans[] = new int[n-k+1];

        Deque<Integer> deque = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(!deque.isEmpty() && deque.peekFirst()<=i-k){
                deque.pollFirst();
            }
            while(!deque.isEmpty() && nums[deque.peekLast()]<=nums[i]){
                deque.pollLast();
            }
            deque.offerLast(i);
            if(i>=k-1){
                ans[i-k+1] = nums[deque.peekFirst()];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int nums[]={1,3,-1,-3,5,3,6,7};
        int nums1[] = {1};
        System.out.println(Arrays.toString(maxSlidingWindow(nums,3)));

        System.out.println(Arrays.toString(maxSlidingWindow(nums1,1)));
    }
}
