import java.util.Stack;

public class PostfixtoInfix {
    public static void main(String[] args) {
        String s ="abc+*d/";
        System.out.println(postfixToInfix(s));
    }

    public static String postfixToInfix(String s){
        StringBuilder ans = new StringBuilder();
        Stack<String> s1 = new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch= s.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                s1.push(String.valueOf(ch));
            }else{
                String t1 = s1.pop();
                String t2 = s1.pop();
                String con = "("+t2+s.charAt(i)+t1+")";
                s1.push(con);
            }
        }
        return s1.peek();
    }
}
