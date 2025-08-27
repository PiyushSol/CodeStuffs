import java.util.Stack;

public class RemoveKDigits {
    public static void main(String[] args) {
        String s ="10200";
        System.out.println(removeKdigits(s,3));
    }

    public static String removeKdigits(String num, int k) {
        Stack<Character> s = new Stack<>();
        for(int i=0;i<num.length();i++){
            while (!s.isEmpty() && k>0 && s.peek()-'0'>num.charAt(i)-'0'){
                s.pop();
                k--;
            }
            s.push(num.charAt(i));
        }
        while(k>0){
            s.pop();
            k--;
        }
        if(s.isEmpty())return "0";
        StringBuilder res = new StringBuilder();
        while (!s.isEmpty()){
            res.append(s.peek());
            s.pop();
        }
        System.out.println(res);
        res.reverse();
        System.out.println(res);
        while (res.length() > 0 && res.charAt(0) == '0') {
            res.deleteCharAt(0);
        }

        return res.length() == 0 ? "0" : res.toString();
    }
}
