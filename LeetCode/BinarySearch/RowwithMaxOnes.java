public class RowwithMaxOnes {
    public static void main(String[] args) {
        int [][] r = {{1, 1, 1}, {0, 0, 1}, {0, 0, 0}};
        int i=rowWithMax1s(r);
        System.out.println(i);
    }

    public static int rowWithMax1s(int[][] mat) {
        int cnt_max =0;
        int idx= -1;
        for(int i=0;i<mat.length;i++){
            int cnt = mat[i].length-lowerBound(mat[i],1);
            if(cnt>cnt_max){
                cnt_max=cnt;
                idx=i;
            }
        }
        return idx;
    }


    public static int lowerBound(int nums[] ,int x){
        int low=0 , high = nums.length-1;
        int ans = nums.length;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid]>=x){
                ans=mid;
                high =mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
}
