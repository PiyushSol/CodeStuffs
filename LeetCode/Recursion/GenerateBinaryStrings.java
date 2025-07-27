import java.util.ArrayList;
import java.util.List;

public class GenerateBinaryStrings {
    public static void main(String[] args) {
        System.out.println(generateBinaryStrings(3));
    }

    public static List<String> generateBinaryStrings(int n) {
         return helper(n,new String(),false);
    }

    public static List<String> helper(int  n , String s , boolean lastOne){
        List<String> ans = new ArrayList<>();
        if(n==0){
            ans.add(s);
            return ans;
        }

        //List of zero starting string
            ans.addAll(helper(n-1,s+"0",false));
            if(!lastOne){
                ans.addAll(helper(n-1,s+"1",true));
            }
        return ans;
    }


    //This one uses StringBuilder and backtracking to keep the string safe.
    public static List<String> helper2(int n, StringBuilder s, boolean lastOne) {
        List<String> ans = new ArrayList<>();

        if (n == 0) {
            ans.add(s.toString());
            return ans;
        }

        // Try adding '0'
        s.append('0');
        ans.addAll(helper2(n - 1, s, false));
        s.deleteCharAt(s.length() - 1);

        // Try adding '1' only if lastOne is false
        if (!lastOne) {
            s.append('1');
            ans.addAll(helper2(n - 1, s, true));
            s.deleteCharAt(s.length() - 1);
        }

        return ans;
    }
}
