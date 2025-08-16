public class KthElementOfSortedArrays {
    public static void main(String[] args) {
    int[] a = {2,3,6,7,9};
    int[] b= {1,4,8,10};
    int k=5;
        System.out.println(kthElement(a,b,k));
    }

    public static int kthElement(int[] a, int[] b, int k) {
        int n1= a.length;
        int n2=b.length;
        if(n1>n2){
            return kthElement(b,a,k);
        }
        int low=Math.max(0,k-n2) , high=Math.min(k,n1);
        int left = k;
        int n = n1+n2;
        while(low<=high){
            int mid1 = low+(high-low)/2;
            int mid2 = left-mid1;
            int l1 = Integer.MIN_VALUE, l2=Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE , r2=Integer.MAX_VALUE;
            if(mid1<n1) r1 = a[mid1];
            if(mid2<n2) r2 = b[mid2];
            if(mid1-1>=0) l1 = a[mid1-1];
            if(mid2-1>=0) l2=b[mid2-1];
            if(l1<=r2 && l2<=r1){
                    return Math.max(l1,l2);
            } else if (l1>r2) {
                high=mid1-1;
            }else{
                low = mid1+1;
            }
        }
        return -1;
    }
}
