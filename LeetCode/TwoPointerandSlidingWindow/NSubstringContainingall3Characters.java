public class NSubstringContainingall3Characters {
    public static void main(String[] args) {
        System.out.println(numberOfSubstrings("abcabc"));
    }

    public static int numberOfSubstrings(String s) {
      int[] lastSeen = {-1,-1,-1};
      int count=0;
      for(int i=0;i<s.length();i++){
          lastSeen[s.charAt(i)-'a']=i;
          if(lastSeen[0]!=-1 && lastSeen[1]!=-1 && lastSeen[2]!=-1){
              count+= 1+Math.min(Math.min(lastSeen[0],lastSeen[1] ),lastSeen[2]);
          }
      }
      return count;
    }

    public static int CnumberOfSubstrings(String s) {
        int count=0;
        int n=s.length();
        for(int i=0;i<n;i++){
            int[]hash = new int[3];
            for(int j=i;j<n;j++){
                hash[s.charAt(j)-'a']=1;
                if(hash[0]+hash[1]+hash[2]==3){
                    count = count + n-j;
                    break;
                }
            }
        }
        return count;
    }
}
