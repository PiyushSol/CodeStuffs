import java.util.Stack;

public class PrefixtoInfix {
    public static void main(String[] args) {
        String s="*+AB-CD";
        System.out.println(prefixToInfix(s));
    }

    public static String prefixToInfix(String s){
        Stack<String> st = new Stack<>();
        for(int i=s.length()-1;i>=0;i--){
            char ch = s.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                st.push(String.valueOf(ch));
            }else{
                String t1 = st.pop();
                String t2=st.pop();
                String converted = "("+t1+s.charAt(i)+t2+")";
                st.push(converted);
            }
        }
    return st.peek();
    }

}
