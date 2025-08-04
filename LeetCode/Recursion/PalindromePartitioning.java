import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public static void main(String[] args) {
        System.out.println(partition("a"));
    }

    public static List<List<String>> partition(String s){
        List<List<String>> ans = new ArrayList<>();
        partitionString(s,new ArrayList<>(),ans);
        return ans;
    }

    //Palindrome Partitioning
    public static void partitionString(String up, List<String> temp , List<List<String>> ans){
        if(up.isEmpty()){
                ans.add(new ArrayList<>(temp));
                return;
        }

        for(int i=1;i<=up.length();i++){
            String curr = up.substring(0,i);
            if(isPalindrome(curr)){
                temp.add(curr);
                partitionString(up.substring(i),temp,ans);
                temp.remove(temp.size()-1);
            }
        }

    }

    //To check if give string is pallindrome
    public static boolean isPalindrome(String s){
        int l = 0 , h = s.length()-1;
        while(l<h){
            if(s.charAt(l)!=s.charAt(h)){
                return false;
            }
            l++;
            h--;
        }
        return true;
    }
}
