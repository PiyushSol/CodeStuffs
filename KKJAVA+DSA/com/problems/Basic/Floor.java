package com.problems.Basic;

public class Floor {
    public static void main(String[] args) {
        int[] arr={2,3,5,9,14,16,18};
        System.out.println(floor( arr,15));
    }

    public static int floor(int []nums , int target){
        int start=0;
        int end=nums.length-1;

        while(start<=end){
            int mid =start+(end-start)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid]>target){
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return end ;
    }
}
