import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElement2 {
    public static void main(String[] args) {
        int ans[] = {1,2,3,4,3};
        System.out.println(Arrays.toString(nextGreaterElements(ans)));
    }

    public static int[] nextGreaterElements(int[] nums) {
        Stack<Integer>st = new Stack<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        int n=nums.length;
        int []ans = new int[n];
        for(int i=2*n-1;i>=0;i--){
            while(!st.isEmpty() && st.peek()<=nums[i%n]){
                st.pop();
            }
            if (i < n) {
                ans[i] = st.isEmpty() ? -1 : st.peek();
            }
            st.push(nums[i%n]);
        }
        return ans;
    }
}
