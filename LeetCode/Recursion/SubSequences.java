import java.util.List;

public class SubSequences {
    public static void main(String[] args) {
        int arr[]= new int[]{4,9,2,5,1};
        int k=10;
        int n =5;
        int c =countS(0,0,k,arr,n);
        System.out.println(c);
    }

    //Count the total subsequeces whose sum is k
    public static int countS(int idx , int s , int k , int arr[],int n){
        if(idx==n){
            if(s ==k){
                return 1;
            }
            else return 0;
        }

        s+=arr[idx];
        int left =countS(idx+1,s,k,arr,n);

        s-=arr[idx];
        int right = countS(idx+1,s,k,arr,n);


        return left+right;
    }

    //Print all the subsequences whose sum is k

    public static void printS1(int idx , List<Integer> ds , int s , int k , int arr[],int n){
        if(idx==n){
            if(s ==k){
                System.out.println(ds);
            }
            return;
        }

        ds.add(arr[idx]);
        s+=arr[idx];
        printS1(idx+1,ds,s,k,arr,n);
        s-=arr[idx];
        ds.remove(ds.size()-1);

        printS1(idx+1,ds,s,k,arr,n);
    }

    public static boolean printS(int idx , List<Integer> ds , int s , int k , int arr[],int n){
        if(idx==n){
            if(s ==k){
                System.out.println(ds);
                return true;
            }
            else return false;
        }

        ds.add(arr[idx]);
        s+=arr[idx];
        if(printS(idx+1,ds,s,k,arr,n)){
            return true;
        }

        ds.remove(ds.size()-1);
        s-=arr[idx];
        if(printS(idx+1,ds,s,k,arr,n)){
            return true;
        }

        return false;
    }
}
