import java.util.HashMap;
import java.util.Map;

public class KDistinctCharacter {
    public static void main(String[] args) {
       String s = "aababbcaacc" ;
       int k = 2;
        System.out.println(kDistinctChar(s,k));
    }

    public static int kDistinctChar(String s, int k) {
        int l=0 , r=0 , maxlen=0;
        int n=s.length();
        Map<Character,Integer> map = new HashMap<>();
        while(r<n){
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r),0)+1);
            if(map.size()>k){
                map.put(s.charAt(l),map.get(s.charAt(l))-1);
                if(map.get(s.charAt(l))==0){
                    map.remove(s.charAt(l));
                }
                l++;
            }
            maxlen = Math.max(maxlen,r-l+1);
            r++;
        }
        return maxlen;
    }
}
