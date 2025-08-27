import java.util.Stack;

public class SumofSubarrayMinimums {
    public static void main(String[] args) {
        int arr[]= {3,1,2,4};
        int arr1[]={11,81,94,43,3};
        System.out.println(sumSubarrayMins(arr));
        System.out.println(sumSubarrayMins(arr1));
    }

    public static int sumSubarrayMins(int[] arr) {
     int n=arr.length;
     long sum=0;
     int MOD =1000000007;
     int nse[]= new int[n];
     int pse[] =new int[n];
     Stack<Integer>s = new Stack<>();
     //Counting Previous Smaller Element
     for(int i=0;i<n;i++) {
         while(!s.isEmpty() &&arr[s.peek()]>arr[i]){
             s.pop();
         }
         pse[i] = s.isEmpty()?-1:s.peek();
         s.push(i);
     }
     s.clear();
     //Counting Next Smaller Element
     for(int i=n-1;i>=0;i--){
         while(!s.isEmpty() && arr[s.peek()]>=arr[i]){
             s.pop();
         }
         nse[i]=s.isEmpty()?n:s.peek();
         s.push(i);
     }

     for(int i=0;i<n;i++){
         int left = i -pse[i];
         int right = nse[i]-i;
         sum = (sum + (long)left * right % MOD * arr[i] % MOD) % MOD;;
     }
     return (int)sum;
    }
}
