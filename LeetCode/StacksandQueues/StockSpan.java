import java.util.Stack;

public class StockSpan {
     class StockSpanner {
         Stack<Integer[]> st;
        public StockSpanner() {
            st = new Stack<>();
        }

        public  int next(int price) {
            int span = 1;
            while(!st.isEmpty() && st.peek()[0] <= price){
                span += st.pop()[1];
            }
            st.push(new Integer[]{price, span});
            return span;
        }
    }

    public static void main(String[] args) {
        StockSpan span = new StockSpan();
        System.out.println();
    }
}
