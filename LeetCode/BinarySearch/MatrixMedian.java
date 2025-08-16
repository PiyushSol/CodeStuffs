public class MatrixMedian {
    public static void main(String[] args) {
    int matrix[][] = {{1,4,9},{2,5,6},{3,7,8}};
        System.out.println(findMedian(matrix));
    }

    public static int findMedian(int[][] matrix) {
        int low = matrix[0][0];
        int high = matrix[0][matrix[0].length - 1];
        for (int i = 1; i < matrix.length; i++) {
            low = Math.min(low, matrix[i][0]);
            high = Math.max(high, matrix[i][matrix[i].length - 1]);
        }
        int req = (matrix.length* matrix[0].length)/2;
        while(low<=high){
            int mid = low+(high-low)/2;
            int lessthanequals = lessthan(matrix,mid);
            if(lessthanequals<=req){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return low;
    }

    public static int lessthan(int[][] matrix, int x){
        int cnt = 0;
        for(int i=0;i<matrix.length;i++){
            cnt+= upperBound(matrix[i],x );
        }
        return cnt;
    }

    public static int upperBound(int nums[],int x){
        int low=0 , high = nums.length-1;
        int ans = nums.length;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid]>x){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
}
