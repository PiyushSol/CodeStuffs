import java.util.Arrays;

public class AggresiveCows {
    public static void main(String[] args) {
        int nums[]= {0, 3, 4, 7, 10, 9};
        int n = 6, k=4;
        System.out.println(aggressiveCows(nums,k));
    }

    public static int aggressiveCows(int[] nums, int k) {
        Arrays.sort(nums);
        int n= nums.length;
        int low = 0 , high=nums[n-1]-nums[0];
        while (low<=high){
            int mid= low+(high-low)/2;
            if(canWePlaceCows(nums,mid,k)){
                low=mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return high;
    }

    public static boolean canWePlaceCows(int arr[], int dis, int cows){
        int countCows=1; int last = arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]-last>=dis){
                countCows++;
                last=arr[i];
            }
            if(countCows>=cows){
                return true;
            }
        }
        return false;
    }
}
