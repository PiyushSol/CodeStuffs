import java.util.Stack;

public class SumofSubarrayRanges {
    public static void main(String[] args) {
        int n[]={1,2,3};
        int m[]={1,3,3};
        System.out.println(subArrayRanges(n));
        System.out.println(subArrayRanges(m));
    }

    public static long subArrayRanges(int[] nums) {
        return subArraySumMax(nums)-subArraySumMinmum(nums);
    }

    public static long subArraySumMinmum(int []nums){
        int n= nums.length;
        int nse[]= new int[n];
        int pse[]= new int[n];
        long sum=0;
        Stack<Integer> s = new Stack<>();
        //Previous Smaller Element
        for(int i=0;i<n;i++){
            while(!s.isEmpty() && nums[s.peek()]>nums[i]){
                s.pop();
            }
            pse[i] = s.isEmpty()?-1:s.peek();
            s.push(i);
        }

        s.clear();
        //Next Smaller Element
        for(int i=n-1;i>=0;i--){
            while(!s.isEmpty() && nums[s.peek()]>=nums[i]){
                s.pop();
            }
            nse[i] = s.isEmpty()?n:s.peek();
            s.push(i);
        }

        for(int i=0;i<n;i++){
            int l = i-pse[i];
            int r=nse[i]-i;
            sum += ((long) (l*r)*nums[i]);
        }
        return sum;
    }


    public static long subArraySumMax(int [] nums){
        int n= nums.length;
        int nge[]= new int[n];
        int pge[]= new int[n];
        long sum=0;
        Stack<Integer> s = new Stack<>();
        //Previous Smaller Element
        for(int i=0;i<n;i++){
            while(!s.isEmpty() && nums[s.peek()]<nums[i]){
                s.pop();
            }
            pge[i] = s.isEmpty()?-1:s.peek();
            s.push(i);
        }

        s.clear();
        //Next Smaller Element
        for(int i=n-1;i>=0;i--){
            while(!s.isEmpty() && nums[s.peek()]<=nums[i]){
                s.pop();
            }
            nge[i] = s.isEmpty()?n:s.peek();
            s.push(i);
        }

        for(int i=0;i<n;i++){
            int l = i-pge[i];
            int r=nge[i]-i;
            sum += ((long)(l*r)*nums[i]);
        }
        return sum;
    }
}
