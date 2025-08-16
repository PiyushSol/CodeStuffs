/*
Given an integer array nums. Return the number of inversions in the array.
Two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.

It indicates how close an array is to being sorted.
A sorted array has an inversion count of 0.
An array sorted in descending order has maximum inversion.
 */
public class CountInversions {
    static int cnt =0;
    public static void main(String[] args) {
    int nums1[]={2, 3, 7, 1, 3, 5};
    int nums2[]={-10, -5, 6, 11, 15, 17};
        System.out.println(numberOfInversions(nums1));
        System.out.println(numberOfInversions(nums2));
    }

    public static long numberOfInversions(int[] nums) {
        int n=nums.length;
        mergeSort(nums,0,n-1);
        return cnt;
    }

    public static void merge(int a[],int low , int mid, int high){
        int res[] =new int[high-low+1];
        int i=low,j=mid+1;
        int k=0;
        while(i<=mid && j<=high){
            if(a[i]<=a[j]){
                res[k]=a[i];
                i++;
            }
            else{
                res[k]=a[j];
                cnt +=(mid-i+1);
                j++;
            }
            k++;
        }

        while(i<=mid){
            res[k++]=a[i++];
        }
        while(j<=high){
            res[k++]=a[j++];
        }

        for(int m=0;m<res.length;m++){
            a[m+low] = res[m];
        }
    }

    public static void mergeSort(int a[],int low, int high){
        if(low<high){
            int mid = (high+low)/2;
            mergeSort(a,low,mid);
            mergeSort(a,mid+1,high);
            merge(a,low,mid,high);
        }
    }

    public static long numberOfInversions1(int[] nums) {
        int n=nums.length;
        int cnt=0;
        for(int i=0;i<n;i++){
            int j=n-1;
            while(j>i){
                if(nums[i]>nums[j]){
                    cnt++;
                }
                j--;
            }
        }
        return cnt;
    }
}
