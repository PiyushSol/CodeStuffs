import java.util.Arrays;

public class RepeatingandMissingNumber {
    public static void main(String[] args) {
     int nums[]={1, 2, 3, 6, 7, 5, 7};
        System.out.println(Arrays.toString(findMissingRepeatingNumbers(nums)));
    }

    public static int[] findMissingRepeatingNumbers(int[] nums) {
        //Apporach 2 using maths and more optimal
        //S-Sn then S2-S2n
        long n= nums.length;
        long Sn = (n *(n+1))/2;
        long S2n = (n*(n+1)*(2*n+1))/6;
        long S =0 ,S2=0;
        for(int i=0;i<n;i++){
            S += nums[i];
            S2 += ((long) nums[i] *nums[i]);
        }

        long val1 = S-Sn;
        long val2 = S2-S2n;
        val2 = val2/val1;
        long x = (val1+val2)/2;
        long y= x-val1;
        return new int[] {(int) x, (int) y};
    }

    public static int[] findMissingRepeatingNumbers1(int[] nums) {
        //Apporach 1 using hashing
        int n= nums.length;
        int hash[]=new int[n+1];
        for(int i=0;i<n;i++){
            hash[nums[i]]++;
        }
        int missing = -1, repeating =-1;
        for(int i=1;i<=n;i++){
            if(hash[i]>1){
                repeating=i;
            }
            if(hash[i]==0){
                missing=i;
            }
        }
        return new int[]{repeating,missing};
    }
}
