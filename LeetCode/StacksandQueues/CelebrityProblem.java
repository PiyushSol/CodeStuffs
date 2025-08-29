public class CelebrityProblem {
    public static void main(String[] args) {
        int[][] mat = {{0,1,1,0},{0,0,0,0},{1,1,0,0},{0,1,1,0}};
        System.out.println(celebrity(mat));
    }

    public static int celebrity(int[][] M) {
        int n = M.length;
        int top = 0;
        int down = n - 1;

        // Step 1: Find potential celebrity
        while (top < down) {
            if (M[top][down] == 1) {
                top++; // top knows down → top can't be celebrity
            } else if (M[down][top] == 1) {
                down--; // down knows top → down can't be celebrity
            } else {
                top++;
                down--;
            }
        }

        // If pointers crossed (edge case), no candidate
        if (top > down) {
            return -1;
        }

        // Step 2: Validate candidate
        for (int i = 0; i < n; i++) {
            if (i == top) continue;

            // Candidate should know no one, and everyone should know candidate
            if (M[top][i] == 1 || M[i][top] == 0) {
                return -1;
            }
        }

        return top; // Valid celebrity
    }

}
