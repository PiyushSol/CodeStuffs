package Codes.Sorting;

import java.util.Arrays;

public class Sorting {
    public static void main(String[] args) {
//        int[] a = {10,9,8,7,6,5,4,3,2,1};
//        int[]b = mergeSort1(a);
//        System.out.println(Arrays.toString(b));
//        quickSort(a,0,a.length-1);
//        Arrays.sort(a);
//        System.out.println(Arrays.toString(a));
    }

    //Quick Sort Algorithm
    public static void quickSort(int []a , int low , int high){
        if(low>=high){
            return;
        }
        int s=low;
        int e=high;
        int m = s+(e-s)/2;
        int pivot = a[m];
        while(s<=e){
            while(a[s]<pivot)s++;
            while(a[e]>pivot)e--;
            if(s<=e){
                int temp = a[s];
                a[s]=a[e];
                a[e]=temp;
                s++;
                e--;
            }
        }
        quickSort(a,low,e);
        quickSort(a,s,high);
    }

    public static int[] mergeSort1(int[] a){
        if(a.length ==1){
            return a;
        }
        int mid = a.length/2;
        int[] left = mergeSort1(Arrays.copyOfRange(a,0,mid));
        int[] right = mergeSort1(Arrays.copyOfRange(a,mid,a.length));

        return merge1(left,right);
    }

    public static  int[] merge1(int []first , int [] second){
        int mix[] = new int[first.length+ second.length];
        int i=0 , j=0;
        int k=0;
        while(i< first.length && j< second.length){
            if(first[i]<second[j]){
                mix[k]=first[i];
                i++;
            }
            else{
                mix[k]=second[j];
                j++;
            }
            k++;
        }

        while(i< first.length){
            mix[k]=first[i];
            i++;
            k++;
        }

        while(j< second.length){
            mix[k]=first[j];
            j++;
            k++;
        }

        return mix;
    }

    public static void merge(int a[],int low, int mid, int high){
        int i=low , j=mid+1, k=0;
        int [] b = new int[high-low+1];
        while(i<=mid && j<=high){
            if(a[i]<=a[j]){
                b[k] =a[i++];
            }
            else{
                b[k]=a[j++];
            }
            k++;
        }
        while(i<=mid){
            b[k++]=a[i++];
        }
        while(j<=high){
            b[k++]=a[j++];
        }
        for(int m=0;m<=high-low;m++){
            a[low+m]=b[m];
        }
    }

    public static void mergeSort(int a[], int low , int high){
        if(low<high){
            int mid = (high+low)/2;
            mergeSort(a,low,mid);
            mergeSort(a,mid+1,high);
            merge(a,low,mid,high);
        }
    }
}
