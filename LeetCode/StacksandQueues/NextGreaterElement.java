import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {

    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st=new Stack<>();
        Map<Integer, Integer> ngeMap = new HashMap<>();
        for(int i= nums2.length-1;i>=0;i--){
            while(!st.isEmpty() && st.peek()<=nums2[i]){
                st.pop();
            }
            int el = st.isEmpty()?-1:st.peek();
            ngeMap.put(nums2[i],el );
            st.push(nums2[i]);
        }
        for(int i=0;i< nums1.length;i++){
           nums1[i] = ngeMap.get(nums1[i]);
        }
        return nums1;
    }
}
