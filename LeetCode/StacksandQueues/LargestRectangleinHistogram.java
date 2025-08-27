import java.util.Stack;

public class LargestRectangleinHistogram {
    public static void main(String[] args) {
  int a[]={2,4};
        System.out.println(largestRectangleArea(a));
    }

    public static int largestRectangleArea(int[] heights) {
    int n= heights.length;
    int nse= 0 , pse =0;
        Stack<Integer> st = new Stack<>();
     int maxArea = Integer.MIN_VALUE;
    for(int i=0;i<n;i++){
        while(!st.isEmpty() && heights[st.peek()]>heights[i]){
            int el = st.pop();
            nse = i;
            pse =st.empty()?-1:st.peek();
            maxArea = Math.max(maxArea,heights[el]*(nse-pse-1));
        }
        st.push(i);
    }
    while (!st.isEmpty()){
        nse = n;
        int el = st.pop();
        pse =st.empty()?-1:st.peek();
        maxArea = Math.max(maxArea,heights[el]*(nse-pse-1));
    }

    return maxArea;
    }
}
