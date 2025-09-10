public class NinjaTraining {
    public static int ninjaTraining(int[][] matrix) {
        int dp[][] = new int[matrix.length][4];
        dp[0][0]=Math.max(matrix[0][1],matrix[0][2]);
        dp[0][1]=Math.max(matrix[0][2],matrix[0][0]);
        dp[0][2]=Math.max(matrix[0][0],matrix[0][1]);
        dp[0][3]=Math.max(Math.max(matrix[0][0],matrix[0][1]),matrix[0][2]);

        for(int day=1;day<matrix.length;day++){
            for(int last=0;last<4;last++){
                dp[day][last]=0;
                for(int task=0;task<3;task++){
                    if(last!=task){
                        int point = matrix[day][task]+ dp[day-1][task];
                        dp[day][last] =Math.max(point,dp[day][last]);
                    }
                }
            }
        }
        return dp[matrix.length-1][3];
    }

    public static void main(String[] args) {
        int[][]mat ={{10,40,70},
                {20,50,80},
                {30,60,90}};
        System.out.println(ninjaTraining(mat));
    }
}
