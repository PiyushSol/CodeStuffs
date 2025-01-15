package com.problems.Basic;
//Question to find position of an element in an infinite sorted array.
public class SortedArray {
    public static void main(String[] args) {
        //Start with box of 2 and double it every time if element not in the range
    int[] arr={3,5,7,9,10,90,100,130,140,160,170};
    int target =10;
        System.out.println(searchInfiniteArray(arr,target));
    }

    public static int searchInfiniteArray(int []arr,int target){
        //first find range
        int start=0;
        int end=1;

        //Condition for the target to lie in the range
        while (target>arr[end]){
            int newStart=end+1;
            end= end+(end-start+1)*2;
            start=newStart;
        }
        return binarySearch(arr,target,start,end);
    }
    public static int binarySearch(int[]arr,int target,int start ,int end){
        while(start<=end){
            int mid=start+(end-start)/2;
            if(target<arr[mid]){
                end=mid-1;
            }
            else if(target>arr[mid]){
                start=mid+1;
            }
            else{
                return mid;
            }
        }
        return -1;
    }

}
