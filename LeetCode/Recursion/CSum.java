import java.util.ArrayList;
import java.util.List;

public class CSum {
    public static void main(String args[]){
        System.out.println(combinationSum(new int[]{2,3,6,7},7));
    }

    //Combination Sum
    public static void findCombinations(int idx , int[]arr , int target , List<List<Integer>>ans , List<Integer>ds){
        if(idx == arr.length){
            if(target ==0){
                ans.add(new ArrayList<>(ds));
            }
            return;
        }

        if(arr[idx]<=target){
            ds.add(arr[idx]);
            findCombinations(idx,arr,target-arr[idx],ans,ds);
            ds.remove(ds.size()-1);
        }
        findCombinations(idx+1, arr, target, ans, ds);
    }

    public static List<List<Integer>> combinationSum(int[]candidates , int target){
        List<List<Integer>>ans =new ArrayList<>();
        findCombinations(0,candidates,target,ans,new ArrayList<>());
        return ans;
    }
}
