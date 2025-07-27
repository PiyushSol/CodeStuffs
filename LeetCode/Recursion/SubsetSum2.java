import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetSum2 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,2};
        System.out.println(subsetsWithDup(nums));
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        subsetS(0,nums,ans,new ArrayList<>());
        return ans;
    }

    public static void subsetS(int idx , int arr[],List<List<Integer>>ans,List<Integer>temp){

            ans.add(new ArrayList<>(temp));

        for(int i=idx;i<arr.length;i++){
            if(i>idx && arr[i]==arr[i-1]){
                continue;
            }
            temp.add(arr[i]);
            subsetS(i+1,arr,ans, temp);
            temp.remove(temp.size()-1);
        }
    }
}
