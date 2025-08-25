import java.util.Stack;

public class InfixtoPrefix {
    public static void main(String[] args) {
        String s ="x+y*z/w+u";
        System.out.println(infixToPrefix(s));
    }

    public static String infixToPrefix(String s) {
        //Reverse the infix -> COnvert infix to postfix -> then reverse it back bang
        String s1 = reverse(s);
        String ans =infixToPostfix(s1);
        return reverse(ans);

    }

    public static String reverse(String s){
        char[] arr = s.toCharArray();
        int i = 0, j = arr.length - 1;

        while (i <= j) {
            char leftChar = arr[i];
            char rightChar = arr[j];


            if (leftChar == '(') leftChar = ')';
            else if (leftChar == ')') leftChar = '(';


            if (rightChar == '(') rightChar = ')';
            else if (rightChar == ')') rightChar = '(';

            arr[i] = rightChar;
            arr[j] = leftChar;

            i++;
            j--;
        }

        return new String(arr);
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
