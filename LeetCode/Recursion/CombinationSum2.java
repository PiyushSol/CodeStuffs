import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
    public static void main(String[] args) {
        System.out.println(combinationSum2(new int[]{10,1,2,7,6,1,5},8));
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        int n = candidates.length;
        List<List<Integer>>ans = new ArrayList<>();
        findCombinations(0,target,candidates,ans,new ArrayList<>());
        return ans;
    }

    public static void findCombinations(int idx , int target,int arr[], List<List<Integer>>ans , List<Integer>temp){
        if(target ==0){
            ans.add(new ArrayList<>(temp));
            return;
        }

        for(int i=idx;i<arr.length;i++){
            if(i>idx && arr[i]==arr[i-1]){
                continue;
            }
            if(arr[i]>target){
                break;
            }
            temp.add(arr[i]);
            findCombinations(i+1,target-arr[i],arr,ans,temp);
            temp.remove(temp.size()-1);
        }

    }
}
