import java.util.ArrayList;
import java.util.List;

public class addOperators {
    public static void main(String[] args) {
        System.out.println(addOperators("232",8));
        System.out.println(addOperators("105",5));
    }

    public static List<String> addOperators(String num, int target) {
            List<String>ans =new ArrayList<>();
            solve(0,num,target,ans,"",0L,0L);
            return ans;
    }

    public static void solve(int idx, String num, int target, List<String> ans, String expr, long prev, long res) {
        if (idx == num.length()) {
            if (res == target) {
                ans.add(expr);
            }
            return;
        }

        for (int i = idx; i < num.length(); i++) {
            // Skip numbers with leading zero
            if (num.charAt(idx) == '0' && i > idx) break;

            String currStr = num.substring(idx, i + 1);
            long currVal = Long.parseLong(currStr);

            if (idx == 0) {
                solve(i + 1, num, target, ans, currStr, currVal, currVal);
            } else {
                solve(i + 1, num, target, ans, expr + "+" + currStr, currVal, res + currVal);
                solve(i + 1, num, target, ans, expr + "-" + currStr, -currVal, res - currVal);
                solve(i + 1, num, target, ans, expr + "*" + currStr, prev * currVal, res - prev + (prev * currVal));
            }
        }
    }
}
