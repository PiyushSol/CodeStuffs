import java.util.Stack;

public class MaximalRectangle {
    public static void main(String[] args) {

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

    public static int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;

        int n = matrix.length;
        int m = matrix[0].length;
        int[][] preSum = new int[n][m];

        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                if (matrix[i][j] == '1') {
                    preSum[i][j] = (i > 0 ? preSum[i - 1][j] : 0) + 1;
                } else {
                    preSum[i][j] = 0;
                }
            }
        }

        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            maxArea = Math.max(maxArea, largestRectangleArea(preSum[i]));
        }
        return maxArea;
    }
}
