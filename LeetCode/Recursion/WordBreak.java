import java.util.ArrayList;
import java.util.List;

public class WordBreak {


    public static void main(String[] args) {
    List<String>wordDict = new ArrayList<>();
    wordDict.add("apple");
    wordDict.add("pen");
    String s = "applepenapple";
        System.out.println(wordBreak(s,wordDict));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        return solve(0,s,wordDict);
    }

    public static boolean solve(int idx , String s , List<String>wordDict){
        if(idx == s.length()){
            return true;
        }

        if(wordDict.contains(s)){
            return true;
        }
        for(int i=idx+1;i<=s.length();i++){
            String temp = s.substring(idx,i);
            if(wordDict.contains(temp) && solve(i,s,wordDict)){
                return true;
            }
        }
        return false;
    }


    public static boolean memoizedwordBreak(String s, List<String> wordDict) {
        return memoizedsolve(0,s,wordDict , new Boolean[s.length()]);
    }

    public static boolean memoizedsolve(int idx , String s , List<String>wordDict,Boolean memo[]){
        if(idx == s.length()){
            return true;
        }
        if(memo[idx]!=null)return memo[idx];

        for(int i=idx+1;i<=s.length();i++){
            String temp = s.substring(idx,i);
            if(wordDict.contains(temp) && memoizedsolve(i,s,wordDict,memo)){
                memo[idx]=true;
                return true;
            }
        }
        memo[idx]=false;
        return false;
    }
}
