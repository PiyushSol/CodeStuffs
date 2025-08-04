public class LongestRepeatingCharacter {
    public static void main(String[] args) {
        String s="ABAB";
        int k = 1;
        System.out.println(characterReplacement(s,k));
    }

    public static int characterReplacement(String s, int k) {
        int maxlen=0;
        int l=0 , r=0, maxfreq=0;
        int[]hash = new int[26];
        while(r<s.length()){
            hash[s.charAt(r)-'A']++;
            maxfreq = Math.max(maxfreq,hash[s.charAt(r)-'A']);
            if((r-l+1)-maxfreq>k){
                hash[s.charAt(l)-'A']--;
                l++;
            }
            maxlen = Math.max((r-l+1),maxlen);
            r++;
        }
        return maxlen;
    }
}
