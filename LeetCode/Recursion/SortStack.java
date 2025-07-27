import java.util.Stack;

public class SortStack {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(4);
        st.push(1);
        st.push(3);
        st.push(2);
        sort(st);
        while(!st.isEmpty()){
            System.out.println(st.pop());
        }
    }

    public static void sort(Stack<Integer> st){
          if(st.isEmpty()){
              return;
          }
          int top = st.pop();
          sort(st);
          insertAtCorrectPosition(st, top);

    }

    public static void insertAtCorrectPosition(Stack<Integer>st , int el){
        if(st.isEmpty()|| el > st.peek()){
            st.push(el);
            return;
        }

        int top = st.pop();
        insertAtCorrectPosition(st , el);
        st.push(top);
    }
}
