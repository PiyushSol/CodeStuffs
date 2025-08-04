public class MaxPointsfromCards {
    public static void main(String[] args) {
       int[] cardPoints = new int[]{1,2,3,4,5,6,1};
        System.out.println(maxScore(cardPoints,3));
    }

    public static int maxScore(int[] cardPoints, int k) {
       int lSum=0 , rSum=0 , maxSum=0;
       int n= cardPoints.length;
       for(int i=0;i<k;i++){
           lSum+=cardPoints[i];
       }
       maxSum=lSum;
       int rIdx=n-1;
       for(int j=k-1;j>=0;j--){
           lSum -= cardPoints[j];
           rSum += cardPoints[rIdx];
           rIdx--;
           maxSum = Math.max(maxSum,lSum+rSum);
       }

       return maxSum;
    }
}
