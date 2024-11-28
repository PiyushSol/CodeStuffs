package com.problems;

public class Arrays {
    public static void main(String[] args) {
        int [] res1 = buildArray(new int[]{0, 2, 1, 5, 3, 4});
        int [] res2 = buildArray(new int[]{5,0,1,2,3,4});
        System.out.println(java.util.Arrays.toString(res1));
        System.out.println(java.util.Arrays.toString(res2));
    }

    public static int[] buildArray(int[] nums){
        int[] ans = new int[nums.length];
        for(int i=0;i<ans.length;i++){
            ans[i]=nums[nums[i]];
        }
        return ans;
    }
}
