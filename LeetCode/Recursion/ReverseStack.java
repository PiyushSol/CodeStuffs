import java.util.Stack;

public class ReverseStack {
    public static void main(String[] args) {
        Stack<Integer>st = new Stack<>();
        st.push(4);
        st.push(1);
        st.push(3);
        st.push(2);
        while (!st.isEmpty()){
            System.out.println(st.pop());
        }
    }

    public static void reverseStack(Stack<Integer> st){
        if(st.isEmpty()){
            return;
        }
        int top = st.pop();
        reverseStack(st);
        insertAtBottom(st,top);
    }

    public static  void insertAtBottom(Stack<Integer>st, int el){
        if(st.isEmpty()){
            st.push(el);
            return;
        }

        int top =st.pop();
        insertAtBottom(st,el);
        st.push(top);

    }
}
