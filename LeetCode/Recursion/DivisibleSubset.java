import java.util.ArrayList;
import java.util.List;

public class DivisibleSubset {
    public static void main(String[] args) {
     int []arr = new int[]{5,2,1};
        System.out.println(subsetSum1(arr));
    }

    //Code to find the subsets
    public static List<List<Integer>> subsets(int[] arr){
        List<List<Integer>> result = new ArrayList<>();
        findSubsets(result,new ArrayList<>() , arr , 0);
        return result;
    }

    public static List<Integer> subsetSum1(int nums[]){
        List<Integer> ans = new ArrayList<>();
        subsetSum(ans,nums,0,0);
        return ans;
    }

    public static void subsetSum(List<Integer>ans , int arr[] , int idx,int sum){
        if(idx>= arr.length){
            ans.add(sum);
            return;
        }

        subsetSum(ans,arr,idx+1,sum+arr[idx]);
        subsetSum(ans,arr,idx+1,sum);

    }

    public static void findSubsets(List<List<Integer>>ans , List<Integer>temp , int arr[] , int idx){
        ans.add(new ArrayList<>(temp));
        for(int i=idx ;i<arr.length;i++){
            //We include the number
            temp.add(arr[i]);
            findSubsets(ans,temp,arr,i+1);
            //When we choose not include that number
            temp.remove(temp.size()-1);
        }
    }
}


