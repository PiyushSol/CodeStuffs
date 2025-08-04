public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String s="ADOBECODEBANC";
        String t="ABC";
        System.out.println(minWindow(s,t));
    }

    public static String minWindow(String s, String t) {
        int l=0 , r=0, count=0 , minLen = Integer.MAX_VALUE;
        int startIdx=-1;
        int n=s.length();
        int m=t.length();
        int[] need = new int[256];
        for (char c : t.toCharArray()) {
            need[c]++;
        }
        int[] window = new int[256];
        while(r<n){
            char rightChar = s.charAt(r);
            window[rightChar]++;

            if (need[rightChar] > 0 && window[rightChar] <= need[rightChar]) {
                count++;
            }

            while (count == t.length()) {
                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    startIdx = l;
                }

                char leftChar = s.charAt(l);
                window[leftChar]--;
                if (need[leftChar] > 0 && window[leftChar] < need[leftChar]) {
                    count--;
                }

                l++;
            }

            r++;

        }

        return startIdx==-1?"":s.substring(startIdx,minLen+startIdx);
    }
}
