import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public static void main(String[] args) {
        System.out.println(generate(6));
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans =new ArrayList<>();
        for(int i=1;i<=numRows;i++){
            List<Integer>temp = new ArrayList<>(generateRow(i));
            ans.add(temp);
        }
        return ans;
    }

    public static List<Integer> generateRow(int row){
        long ans=1;
        List<Integer>res = new ArrayList<>();
        res.add(1);
        for(int col=1;col<row;col++){
            ans = ans *(row-col);
            ans = ans/col;
            res.add((int) ans);
        }
        return res;
    }
}
