public class ReversePairs {
    public static void main(String[] args) {
        int nums []={2,4,3,5,1};
        System.out.println(reversePairs(nums));
    }

    public static int reversePairs(int[] nums) {
        int cnt=0;
        cnt = mergeSort(nums,0,nums.length-1);
        return cnt;
    }

    public static void merge(int a[],int low , int mid, int high){
        int res[] =new int[high-low+1];
        int i=low,j=mid+1;
        int k=0;
        int cnt=0;
        while(i<=mid && j<=high){
            if(a[i]<=a[j]){
                res[k]=a[i];
                i++;
            }
            else{
                res[k]=a[j];
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

    public static int mergeSort(int a[],int low, int high){
        int cnt=0;
        if(low<high){
            int mid = (high+low)/2;
            cnt+=mergeSort(a,low,mid);
            cnt+=mergeSort(a,mid+1,high);
            cnt+=countPairs(a,low,mid,high);
            merge(a,low,mid,high);
        }
        return cnt;
    }

    public static int countPairs(int a[],int low, int mid, int high){
        int cnt=0;
        int right=mid+1;
        for(int i=low;i<=mid;i++){
            while(right<=high && (long)a[i]>2L*a[right])right++;
            cnt+= (right - (mid+1));
        }
        return cnt;
    }
}
