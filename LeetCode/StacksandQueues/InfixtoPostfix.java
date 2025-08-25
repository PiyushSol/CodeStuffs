import java.util.Stack;

public class InfixtoPostfix {
    public static void main(String[] args) {
        String exp ="(a+b)*c";
        System.out.println(infixToPostfix(exp));
    }

    public static String infixToPostfix(String s) {
        Stack<Character> st = new Stack<>();
        StringBuilder ans = new StringBuilder();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch>='a' && ch<='z'||ch>='0'&& ch<='9'){
                ans.append(ch);
            } else if (ch =='(') {
                st.push(ch);
            } else if (ch==')') {
                while(!st.isEmpty() && st.peek()!='('){
                    ans.append(st.pop());
                }

                if (!st.isEmpty() && st.peek() == '(') {
                    st.pop();
                }
            }
            else{
                while (!st.isEmpty() && st.peek() != '(' &&
                        getPrecedence(ch) <= getPrecedence(st.peek())) {
                    ans.append(st.pop());
                }
                st.push(ch);
            }

        }
        while(!st.isEmpty()){
            ans.append(st.peek());
            st.pop();
        }

        return ans.toString();
    }

    public static int getPrecedence(char ch){
        if(ch == '^'){
            return 3;
        } else if (ch=='*'||ch=='/') {
            return 2;
        }
        else{
            return 1;
        }
    }

}
