import java.util.ArrayList;
import java.util.List;

public class GenerateParanthesis {
    public static void main(String[] args) {
        System.out.println( generate(3,3,new StringBuilder()));
    }

    public static List<String> generate(int open,int close, StringBuilder sb){
        List<String> ans = new ArrayList<>();
        if(open==0 && close==0){
            ans.add(sb.toString());
            return ans;
        }

        if(open>0){
            sb.append("(");
            ans.addAll(generate(open-1,close,sb));
            sb.deleteCharAt(sb.length()-1);
        }

        if(close>open) {
            sb.append(")");
            ans.addAll(generate(open,close- 1, sb));
            sb.deleteCharAt(sb.length()-1);
        }
        return  ans;
    }
}
