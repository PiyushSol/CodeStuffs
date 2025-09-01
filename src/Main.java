import java.lang.reflect.Array;
import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
          int a[] ={64,8,32};
        System.out.println(maxProduct(a));
    }

    public static long maxProduct(int[] nums) {
        long maxProduct = 0;
        for(int i=0;i< nums.length;i++){
            for(int j=i+1;j< nums.length;j++){
                if((nums[i] & nums[j]) == 0){
                    long  prod = (long) nums[i] *nums[j];
                    maxProduct=Math.max(prod,maxProduct);
                }
                else{
                    break;
                }
            }
        }
        return maxProduct;
    }

    public static int[] recoverOrder(int[] order, int[] friends) {
        int ans[] = new int[friends.length];
        int k=0;
        for(int i=0;i<order.length;i++){
            if(search(friends ,order[i])){
                ans[k++] = order[i];
            }
        }
        return ans;
    }

    public static boolean search (int a[] , int k){
        boolean flag = false;
        for(int i=0;i<a.length;i++){
            if(a[i] == k){
                flag = true;
            }
        }
        return flag;
    }
}