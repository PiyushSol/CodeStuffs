package Codes.Recursion2;
import java.util.ArrayList;

public class Recursion2 {
    public static void main(String[] args) {
//        int a[]={3,2,1,18,9};
//        System.out.println(isSorted(a,0));
//        System.out.println(linearSearch(a,19,0));
//        System.out.println(linearSearch1(a,18,0));
//        int a[]={2,3,1,4,4,5};
//        findAllIndexes(a,4,0);
//        System.out.println(list);
//         ArrayList<Integer> list  = findAllIndexes(a,4,0,new ArrayList<>());
//        System.out.println(list);
        int a[] = {5,6,7,8,9,1,2,3};
        System.out.println(search(a,8,0,a.length-1));

    }

    //rotated binary search
    public static int search(int a[], int k , int s ,int e){
        if (s>e){
            return -1;
        }
        int m= s + (e-s)/2;
        if (a[m]==k){
            return m;
        }
        if (a[s]<=a[m]) {
                if (k>=a[s] && k<=a[m]){
                   return search(a,k,s,m-1);
                }
                else{
                   return  search(a,k,m+1,e);
                }
        }
        if (k>=a[m] && k<=a[e]){
            return search(a,k,m+1,e);
        }
        else{
            return search(a,k,s,m-1);
        }
    }

    //linear search with recursion
    public static ArrayList<Integer> findAllIndexes1(int a[],int key,int idx ){
        ArrayList<Integer> list = new ArrayList<>();
        if (idx ==a.length){
            return list;
        }
        if (a[idx]==key){
            list.add(idx);
        }
        ArrayList<Integer>ansfrombelowCall=  findAllIndexes1(a,key,idx+1);
        list.addAll(ansfrombelowCall);
        return list;
    }

    public static ArrayList<Integer> findAllIndexes(int a[],int key,int idx ,ArrayList<Integer> list){
        if (idx ==a.length){
            return list;
        }
        if (a[idx]==key){
            list.add(idx);
        }
      return  findAllIndexes(a,key,idx+1,list);
    }
//   static ArrayList<Integer> list = new ArrayList<>();
//    public static void findAllIndexes(int a[],int key,int idx ){
//
//        if (idx ==a.length){
//            return ;
//        }
//        if (a[idx]==key){
//            list.add(idx);
//        }
//        findAllIndexes(a,key,idx+1);
//    }
    public static boolean linearSearch(int a[],int target,int idx){
        if (idx == a.length){
            return false;
        }
        return a[idx]== target ||linearSearch(a,target,idx+1);
    }

    public static int linearSearch1(int a[],int key,int idx ){
        if (idx ==a.length){
            return -1;
        }
        if (a[idx]==key){
            return idx;
        }
        else{
            return linearSearch1(a,key,idx+1);
        }
    }

    //find if the array is sorted or not
    public static boolean isSorted(int a[], int s){
        if (s==a.length-1){
            return true;
        }
        return a[s]<a[s+1] && isSorted(a,s+1);
    }
}
