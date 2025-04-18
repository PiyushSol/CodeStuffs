package Recursion;
public class Main {
    public static void main(String[] args) {
//    print(5);
//        System.out.println(fib(6));
        int[] arr = {1,2,3,4,89,100};//0,1,2,3,4,5
        System.out.println(binarySearch(arr,2,0,arr.length));
        System.out.println(binarySearch(arr,1,0,arr.length));
        System.out.println(binarySearch(arr,100,0,arr.length));
        System.out.println(binarySearch(arr,4,0,arr.length));
        System.out.println(binarySearch(arr,5,0,arr.length));
    }
     //function to print 1-5 numbers
    static void print(int n){
        if(n==0){
            return;
        }
        print(n-1);
        System.out.println(n);
    }

    //Find nth fibonacci number
    static int fib(int n){
        if(n==0||n==1){
            return n;
        }
        return fib(n-1)+fib(n-2);
    }

    //BinarySearch using recursion
    static int binarySearch(int[] arr , int key,int s,int e){
        if(s<=e){
            int mid = s+(e-s)/2;
            if(arr[mid]==key){
                return mid;
            }
            if(arr[mid]>key){
                return binarySearch(arr,key,s,mid-1);
            }

            return binarySearch(arr,key,mid+1,e);
        }

        return -1;
    }

}
