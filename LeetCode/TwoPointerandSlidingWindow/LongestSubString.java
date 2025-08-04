import java.util.HashSet;
import java.util.Set;

public class LongestSubString {
    public static void main(String[] args) {
      String s ="abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        int maxLen=0;
        int l=0;
        int n=s.length();
        Set<Character> set = new HashSet<>();

        for (int r = 0; r < n; r++) {
            while (set.contains(s.charAt(r))) {
                set.remove(s.charAt(l));
                l++;
            }
            set.add(s.charAt(r));
            maxLen = Math.max(maxLen, r - l + 1);
        }

        return maxLen;
    }
}
