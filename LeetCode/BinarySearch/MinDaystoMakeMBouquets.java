public class MinDaystoMakeMBouquets {
    public static void main(String[] args) {
  int a[]={1,10,3,10,2};
        System.out.println(minDays(a,3,1));
    }

    public static int minDays(int[] bloomDay, int m, int k) {
        if(m*k > bloomDay.length)return -1;
        int mx = Integer.MIN_VALUE , mn = Integer.MAX_VALUE;
        for(int i=0;i< bloomDay.length;i++){
            mx = Math.max(mx,bloomDay[i]);
            mn = Math.min(mn,bloomDay[i]);
        }
        int low = mn , high = mx;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(isPossible(bloomDay,mid,m,k)){
                high = mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }

    public static boolean isPossible(int []bloomDay , int day , int m , int k){
        int noOfBoquets =0;
        int count=0;
        for(int i=0;i<bloomDay.length;i++){
            if(bloomDay[i]<=day){
                count++;
            }
            else{
                noOfBoquets += (count)/k;
                count=0;
            }
        }
        noOfBoquets+= (count)/k;
        if(noOfBoquets>=m){
            return true;
        }
        else {
            return false;
        }
    }
}
